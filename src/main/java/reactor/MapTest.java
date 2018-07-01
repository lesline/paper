package reactor;

import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class MapTest {
    public static void main(String[] args) {
   /*     Flux.just(5, 10)
                .concatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
                .toStream()
                .forEach(System.out::println);
        System.out.println("-----------------------combineLatest------------------------");


        Flux.combineLatest(
                Arrays::toString,
                Flux.intervalMillis(100).take(5),
                Flux.intervalMillis(50, 100).take(5)
        ).toStream().forEach(System.out::println);*/
    }
}