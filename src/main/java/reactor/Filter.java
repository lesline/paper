package reactor;

import reactor.core.publisher.Flux;

/**
 * @author zhangshaolin
 * @create 2018/5/26
 */
public class Filter {
    public static void main(String[] args) {
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        System.out.println("------------------1---------------------");

//        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        System.out.println("------------------2---------------------");

        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        System.out.println("------------------3---------------------");

        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        System.out.println("------------------filter---------------------");

        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
    }
}