package reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author zhangshaolin
 * @create 2018/5/26
 */
public class FluxHot {
    public static void main(String[] args) throws InterruptedException {
        final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
                .take(10)
                .publish()
                .autoConnect();
        source.subscribe(System.out::println);
        System.out.println("--------------");
        Thread.sleep(5000);


        source
                .toStream()
                .forEach(System.out::println);
    }
}