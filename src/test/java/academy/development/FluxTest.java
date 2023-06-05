package academy.development;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

@Slf4j
@Disabled
public class FluxTest {


    @Test
    void fluxSubscriber() {
        Flux<String> fluxString = Flux.just("Rahul","Manoj","Shivam")
                .log();

        StepVerifier.create(fluxString)
                .expectNext("Rahul","Manoj","Shivam")
                .verifyComplete();
    }

    @Test
    void fluxSubscriberNumber() {
        Flux<Integer> fluxNumebrs = Flux.range(1,5)
                .log();

        fluxNumebrs.subscribe(num -> log.info("Number {}",num));
        log.info("-------------------------------------------------");
        StepVerifier.create(fluxNumebrs)
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }

    @Test
    void fluxSubscriberFromList() {
        Flux<Integer> fluxNumbers = Flux.fromIterable(List.of(1,2,3,4,5))
                .log();

        fluxNumbers.subscribe(num -> log.info("Number {}",num));
        log.info("-------------------------------------------------");
        StepVerifier.create(fluxNumbers)
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }

    @Test
    void fluxSubscriberNumbersError() {
        Flux<Integer> fluxNumebrs = Flux.range(1,5)
                .log()
                .map( n -> {
                    if(n==4) {
                        throw new IndexOutOfBoundsException("index error");
                    }
                    return n;
                });
        fluxNumebrs.subscribe(i -> log.info("Number {}",i),Throwable::printStackTrace,
                () -> log.info("Done !"),subscription -> subscription.request(3));

        log.info("-------------------------------------------------");
        StepVerifier.create(fluxNumebrs)
                .expectNext(1,2,3)
                .expectError(IndexOutOfBoundsException.class)
                .verify();
    }

    @Test
    void fluxSubscriberNumbersUglyBackPressure() {
        Flux<Integer> flux = Flux.range(1,10)
                .log();
        flux.subscribe(new Subscriber<Integer>() {
            private int count=0;
            private Subscription  subscription;
            private int requestCount=2;
            @Override
            public void onSubscribe(Subscription s) {
              this.subscription=s;
              subscription.request(requestCount);
            }

            @Override
            public void onNext(Integer integer) {
                log.info("value {}",integer);
                count++;
                if(count>=2) {
                    count=0;
                    subscription.request(requestCount);
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        log.info("-------------------------------------------------");
        StepVerifier.create(flux)
                .expectNext(1,2,3,4,5,6,7,8,9,10)
                .verifyComplete();
    }

    @Test
    void fluxSubscriberNumbersNotSoUglyBackPressure() {
        Flux<Integer> flux = Flux.range(1,10)
                .log();
        flux.subscribe(new BaseSubscriber<Integer>() {
            private int count=0;
            private final int requestCount=2;

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(requestCount);
            }

            @Override
            protected void hookOnNext(Integer value) {
                log.info("value {}",value);
                count++;
                if(count>=requestCount) {
                    count=0;
                    request(requestCount);
                }
            }
        });

        log.info("-------------------------------------------------");
        StepVerifier.create(flux)
                .expectNext(1,2,3,4,5,6,7,8,9,10)
                .verifyComplete();
    }

    @Test
    void  fluxSubscriberPrettyBackPressure() {

        Flux<Integer> fluxNumebrs = Flux.range(1,10)
                .log()
                .limitRate(3);

        fluxNumebrs.subscribe(num -> log.info("Number {}",num));
        log.info("-------------------------------------------------");
        StepVerifier.create(fluxNumebrs)
                .expectNext(1,2,3,4,5,6,7,8,9,10)
                .verifyComplete();
    }

}
