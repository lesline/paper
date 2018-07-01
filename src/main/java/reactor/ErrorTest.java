package reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class ErrorTest {
    public static void main(String[] args) {
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .subscribe(System.out::println, System.err::println);


        System.out.println("----------------------------onErrorReturn------------------------------");

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .onErrorReturn(0)
                .subscribe(System.out::println);


      /*  System.out.println("----------------------------switchOnError------------------------------");

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .switchOnError(Mono.just(0))
                .subscribe(System.out::println);


        System.out.println("----------------------------onErrorResumeWith------------------------------");

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalArgumentException()))
                .onErrorResumeWith(e -> {
                    if (e instanceof IllegalStateException) {
                        return Mono.just(0);
                    } else if (e instanceof IllegalArgumentException) {
                        return Mono.just(-1);
                    }
                    return Mono.empty();
                })
                .subscribe(System.out::println);

        System.out.println("----------------------------retry------------------------------");*/

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .retry(1)
                .subscribe(System.out::println);

    }
}