package academy.development;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple4;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Operator {

    @Test
    public void subscriptionOn() {
        Flux<Integer> flux = Flux.range(1,100)
                .subscribeOn(Schedulers.boundedElastic())
                .map(i -> {
                    log.info("Map 1 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                })

                .map(i -> {
                    log.info("Map 2 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                })
                .map(i -> {
                    log.info("Map 3 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                });
        flux.subscribe();
//
//        StepVerifier.create(flux)
//                .expectSubscription()
//                .expectNext(1,2,3,4)
//                .verifyComplete();

    }

    @Test
    public void publishOn() {
        Flux<Integer> flux = Flux.range(1,100)
                .map(i -> {
                    log.info("Map 1 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    log.info("Map 2 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                });
        flux.subscribe();
//
//        StepVerifier.create(flux)
//                .expectSubscription()
//                .expectNext(1,2,3,4)
//                .verifyComplete();

    }

    @Test
    public void subscribeAndPublishOnSimple() {
        Flux<Integer> flux = Flux.range(1,4)
                .subscribeOn(Schedulers.single())
                .map(i -> {
                    log.info("Map 1 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    log.info("Map 2 - Number {} on thread {} ",i,Thread.currentThread().getName());
                    return i;
                });
        flux.subscribe();
//
//        StepVerifier.create(flux)
//                .expectSubscription()
//                .expectNext(1,2,3,4)
//                .verifyComplete();

    }

    @Test
    public void subscribeOnIO() {

        URL resource =  this.getClass().getClassLoader().getResource("text-file");
        File file =  new File(resource.getFile());

        Mono<List<String>> monoList = Mono.fromCallable(() -> Files.readAllLines(file.toPath()))
                .log()
                .subscribeOn(Schedulers.boundedElastic());
        monoList.subscribe(s -> log.info("{}",s));
    }

    @Test
    public void switchIfEmptyOperator() {
        Flux<Object> flux = emptyFlux()
                .switchIfEmpty(Flux.just("publisher is empty"))
                .log();

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext("publisher is empty")
                .expectComplete()
                .verify();
    }

    private Flux<Object> emptyFlux() {
        return Flux.empty();
    }

    @Test
    public void deferOperator() throws  Exception{

        // instantiate the publisher one time no matter how many times subscriber is called.
        Mono<Long> just = Mono.just(System.currentTimeMillis());
        just.subscribe(l -> log.info("Just time {}",l));
        Thread.sleep(1000);
        just.subscribe(l -> log.info("Just time {}",l));
        Thread.sleep(1000);
        just.subscribe(l -> log.info("Just time {}",l));
        Thread.sleep(1000);
        just.subscribe(l -> log.info("Just time {}",l));

        // instantiate the publisher each time when multiple subscriber is called.
        Mono<Long> defer = Mono.defer(() -> Mono.just(System.currentTimeMillis()));

        defer.subscribe(l -> log.info("defer time {}",l));
        Thread.sleep(1000);
        defer.subscribe(l -> log.info("defer time {}",l));
        Thread.sleep(1000);
        defer.subscribe(l -> log.info("defer time {}",l));
        Thread.sleep(1000);
        defer.subscribe(l -> log.info("defer time {}",l));

        AtomicLong atomicLong = new AtomicLong();
        defer.subscribe(atomicLong::set);
        Assertions.assertTrue(atomicLong.get() > 0);
    }

    // merge the element lazily
    @Test
    public void concatFlux() {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> flux = Flux.concat(flux1,flux2).log();

//        or
//        Flux<String> flux  = flux1.concatWith(flux2);

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext("a","b","c","d")
                .expectComplete()
                .verify();
    }

    @Test
    public void concatErrorFlux() {
        Flux<String> flux1 = Flux.just("a", "b")
                .map(s -> {
                    if(s.equals("b"))
                        throw new IllegalArgumentException();
                    return s;
                });
        Flux<String> flux2 = Flux.just("c", "d");

//        this will throw exception on 2nd element emit
//        Flux<String> flux = Flux.concat(flux1,flux2).log();

        Flux<String> flux = Flux.concatDelayError(flux1,flux2).log();

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext("a","c","d")
                .expectError()
                .verify();
    }

    // merge the element eagerly
    @Test
    public void mergeOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(200));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> mergeFlux = Flux.merge(flux1,flux2)
                .delayElements(Duration.ofMillis(200))
                .log();
//        or
//        Flux<String> mergeFlux = flux1.mergeWith(flux2)
//                .delayElements(Duration.ofMillis(200))
//                .log();

        mergeFlux.subscribe(log::info);

        Thread.sleep(1000);

        StepVerifier.create(mergeFlux)
                .expectSubscription()
                .expectNext("c","d","a","b")
                .expectComplete()
                .verify();
    }

    // merge the element eagerly
    @Test
    public void mergeSequentialOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(200));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> mergeFlux = Flux.mergeSequential(flux1,flux2,flux1)
                .delayElements(Duration.ofMillis(200))
                .log();

        mergeFlux.subscribe(log::info);

        Thread.sleep(1000);

        StepVerifier.create(mergeFlux)
                .expectSubscription()
                .expectNext("a","b","c","d","a","b")
                .expectComplete()
                .verify();
    }

    // merge the element eagerly
    @Test
    public void mergeDelayErrorOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b")
                .map(s-> {
                    if(s.equals("b"))
                        throw new IllegalArgumentException();
                    return s;
                }).doOnError(e -> log.info("we could do something better"));

        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> mergeFlux = Flux.mergeDelayError(1,flux1,flux2,flux1)
                .log();

        mergeFlux.subscribe(log::info);

        Thread.sleep(1000);

        StepVerifier.create(mergeFlux)
                .expectSubscription()
                .expectNext("a","c","d","a")
                .expectError()
                .verify();
    }

    @Test
    public void flatMapOperator() {
        Flux<String> flux = Flux.just("a", "b");

//        Flux<Flux<String>> fluxFlux = flux.map(String::toUpperCase)
//                .map(this::findByName)
//                .log();

        Flux<String> flatFlux = flux.map(String::toUpperCase)
        .flatMap(this::findByName)
        .log();

        StepVerifier.create(flatFlux)
                .expectSubscription()
                .expectNext("nameA1","nameA2","nameB1","nameB2")
                .verifyComplete();
    }

    public Flux<String> findByName(String name) {
        return name.equals("A") ? Flux.just("nameA1","nameA2") : Flux.just("nameB1","nameB2");
    }

    @Test
    public void flatMapSequentialOperator() {
        Flux<String> flux = Flux.just("a", "b");


//        asynchronously data emitting but not sequentially

//        Flux<String> flatFlux = flux.map(String::toUpperCase)
//                .flatMap(this::findByNameWithDelay)
//                .log();

//         asynchronously data emitting with sequential

        Flux<String> flatFlux = flux.map(String::toUpperCase)
                .flatMapSequential(this::findByNameWithDelay)
                .log();

        StepVerifier.create(flatFlux)
                .expectSubscription()
                .expectNext("nameA1","nameA2","nameB1","nameB2")
                .verifyComplete();
    }

    public Flux<String> findByNameWithDelay(String name) {
        return name.equals("A") ? Flux.just("nameA1","nameA2").delayElements(Duration.ofMillis(100)) : Flux.just("nameB1","nameB2");
    }
    
    @AllArgsConstructor
    @Data
    @ToString
    @EqualsAndHashCode
    class Employee {
        private String name;
        private String address;
        private Integer age;
        private Float salary;
    }

    @Test
    public void zipOperator() {
        Flux<String> nameFlux = Flux.just("Rahul","Manoj");
        Flux<String> addressFlux = Flux.just("Indore","Sanawad");
        Flux<Integer> ageFlux  = Flux.just(25,26);
        Flux<Float> salaryFlux = Flux.just(1000f,2000f);

        Flux<Employee> flux = Flux.zip(nameFlux, addressFlux, ageFlux, salaryFlux)
                .flatMap(e -> Flux.just(new Employee(e.getT1(),e.getT2(),e.getT3(),e.getT4())));

        flux.subscribe(employee -> log.info(employee.toString()));

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext(new Employee("Rahul","Indore",25,1000f),new Employee("Manoj","Sanawad",26,2000f))
                .verifyComplete();
    }

    @Test
    public void zipWithOperator() {
        Flux<String> nameFlux = Flux.just("Rahul","Manoj");
//        Flux<String> addressFlux = Flux.just("Indore","Sanawad");
//        Flux<Integer> ageFlux  = Flux.just(25,26);
        Flux<Float> salaryFlux = Flux.just(1000f);


        Flux<Employee> flux = Flux.zip(nameFlux, salaryFlux)
                .flatMap(e -> Flux.just(new Employee(e.getT1(),null,null, e.getT2())));

        flux.subscribe(employee -> log.info("employee {}",employee.toString()));

//        StepVerifier.create(flux)
//                .expectSubscription()
//                .expectNext(new Employee("Rahul",null,null,1000f),new Employee("Manoj",null,null,2000f))
//                .verifyComplete();

    }
}
