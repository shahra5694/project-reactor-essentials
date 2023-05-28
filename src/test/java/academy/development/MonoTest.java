package academy.development;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class MonoTest {

    @Test
    void verify() {
        String value = "Hello World";
        Mono<String> mono = Mono.just(value).log();

        mono.subscribe(v ->  System.out.println("Mono="+v));
        System.out.println("Mono="+mono);

    }

//    @Test
//    void monoSubcriberConsumerError() {
//        String value = "Hello World";
//        Mono<String> mono = Mono.just(value).map(s -> {throw  new RuntimeException("Testing with mono error");});
//        mono.subscribe(s-> log.info("Name {}",s), s -> log.error("Something bad happened"));
//        mono.subscribe(s-> log.info("Name {}",s), Throwable::printStackTrace);
//        log.info("----------------------------------");
//        StepVerifier.create(mono)
//                .expectError(RuntimeException.class)
//                .verify();
//    }

    @Test
    void monoSubcriberConsumerCompete() {
        String value = "Hello World";
        Mono<String> mono = Mono.just(value).log().map(String::toUpperCase);
        mono.subscribe(s-> log.info("Name {}",s),Throwable::printStackTrace,() -> log.info("finished"));

        log.info("----------------------------------");

        StepVerifier.create(mono)
                .expectNext(value.toUpperCase())
                .verifyComplete();
    }

    @Test
    void monoSubcriberConsumerSubscription() {
        String value = "Hello World";
        Mono<String> mono = Mono.just(value).log().map(String::toUpperCase);
        mono.subscribe(s-> log.info("Name {}",s),Throwable::printStackTrace,() -> log.info("finished"), subscription -> subscription.request(5));

        log.info("----------------------------------");

        StepVerifier.create(mono)
                .expectNext(value.toUpperCase())
                .verifyComplete();
    }

    @Test
    void monoDoOnMethods() {
        String value = "Hello World";
        Mono<Object> mono = Mono.just(value).log()
                .map(String::toUpperCase)
                .doOnSubscribe(s -> log.info("Subscribed"))
                .doOnRequest(num -> log.info("request received , started doing something number {}",num))
                .doOnNext(s -> log.info("doOnNext value is here {}",s))
                .flatMap(s -> Mono.empty())
                .doOnNext(s -> log.info("empty mono {}",s))
                .doOnSuccess(s -> log.info("doOnSuccess executed {}",s));

        mono.subscribe(s-> log.info("Name {}",s),Throwable::printStackTrace,() -> log.info("finished"));

        log.info("----------------------------------");

//        StepVerifier.create(mono)
//                .expectNext(value.toUpperCase())
//                .verifyComplete();
    }

    @Test
    void monoDoOnError(){
        Mono<Object> error = Mono.error(new IllegalArgumentException("IllegalArgumentException"))
                .doOnError(e -> log.error("Error msg = {}", e.getMessage()))
                .doOnNext(s -> log.info("executing doOnNext {}",s))
                .log();

        StepVerifier.create(error)
                .expectError(IllegalArgumentException.class)
                .verify();
    }

    @Test
    void monoDoOnErrorResume(){
        String name= "hello world";
        Mono<Object> error = Mono.error(new IllegalArgumentException("IllegalArgumentException"))
                .doOnError(e -> log.error("Error msg = {}", e.getMessage()))
                .onErrorResume(e -> {
                    log.info("inside error resume");
                    return Mono.just(name);
                })
                .log();

        StepVerifier.create(error)
                .expectNext(name)
                .verifyComplete();
    }

    @Test
    void monoDoOnErrorReturn(){
        String name= "hello world";
        Mono<Object> error = Mono.error(new IllegalArgumentException("IllegalArgumentException"))

                .doOnError(e -> log.error("Error msg = {}", e.getMessage()))
                .onErrorReturn("EMPTY")
                .onErrorResume(e -> {
                    log.info("inside error resume");
                    return Mono.just(name);
                })
                .log();

        StepVerifier.create(error)
                .expectNext("EMPTY")
                .verifyComplete();
    }

    @Test
    void  contextWrite() {
//        String key = "key";
//        Mono<String> stringMono = Mono.just("Spring")
//                .flatMap(t -> Mono.deferContextual(ctx -> Mono.just(t + " " + ctx.get(key))))
//                .flatMap(t -> Mono.deferContextual(ctx -> Mono.just(t + " " + ctx.get(key)))
//                        .contextWrite(ctx -> ctx.put(key, "java")))
//                .contextWrite(ctx -> ctx.put(key, "reactor"));
//
//        StepVerifier.create(stringMono.log()).expectNext("Spring reactor java").verifyComplete();


//        String key = "message";
//        Mono<String> r = Mono
//                .deferContextual(ctx -> Mono.just("Hello " + ctx.get(key)))
//                .contextWrite(ctx -> ctx.put(key, "Reactor"))
//                .flatMap( s -> Mono.deferContextual(ctx ->
//                        Mono.just(s + " " + ctx.get(key))))
//                .contextWrite(ctx -> ctx.put(key, "World")).log();
//
//        StepVerifier.create(r)
//                .expectNext("Hello Reactor World")
//                .verifyComplete();

        String key = "message";
        Mono<String> r = Mono.just("Hello")
                .flatMap( s -> Mono
                        .deferContextual(ctxView -> Mono.just(s + " " + ctxView.get(key)))
                )
                .flatMap( s -> Mono
                        .deferContextual(ctxView -> Mono.just(s + " " + ctxView.get(key)))
//                        .contextWrite(ctx -> ctx.put(key, "Reactor"))
                )
                .contextWrite(ctx -> ctx.put(key, "World")).log();

        StepVerifier.create(r)
                .expectNext("Hello World World")
                .verifyComplete();
    }
}
