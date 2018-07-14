package reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * @author zhangshaolin
 * @create 2018/6/6
 */
public class Test {
    public static void main(String[] args) {
//        Mono.fromCallable( () -> System.currentTimeMillis() )
//                .repeat()
//                .parallel(8) //parallelism
//                .runOn(Schedulers.parallel())
//                .subscribe(System.out::println);
//
//
//        System.out.println("--------");


        Flux flux=  Flux.interval(Duration.ofMillis(200));
        flux.subscribe(System.out::println);




    }
}