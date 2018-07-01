package reactor;

import reactor.core.publisher.Flux;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class WindowTest {
    public static void main(String[] args) {
       /* System.out.println("--------------window---------------");
        Flux.range(1, 100).window(20).subscribe(System.out::println);
        System.out.println("-----------1-----------");
        Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);


        System.out.println("--------------zipwith---------------");
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        System.out.println("-----------1------------");
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);

        System.out.println("----------------reduce-----------------");
        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);


        System.out.println("------------------merge----------------");
        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
        Flux.mergeSequential(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);

        System.out.println("-----------------flatMap-----------------");
        Flux.just(5, 10)
                .flatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
                .toStream()
                .forEach(System.out::println);


        System.out.println("-----------------1-----------------");
        Flux.just(5, 10)
                .flatMapSequential(x -> Flux.intervalMillis(x * 10, 100).take(x))
                .toStream()
                .forEach(System.out::println);


        System.out.println("-----------------concatMap-----------------");

        Flux.just(5, 10).concatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
                .toStream()
                .forEach(System.out::println);*/



    }

}