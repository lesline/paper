package reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author zhangshaolin
 * @create 2018/5/26
 */
public class FluxTest2 {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        System.out.println("------------------start--------------");
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
//        Flux.intervalMillis(1000).subscribe(System.out::println);
        Thread.sleep(5000);

        System.out.println("------------------end----------------");
    }
}