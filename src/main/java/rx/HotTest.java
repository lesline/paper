package rx;

import reactor.core.publisher.Flux;

/**
 * @author zhangshaolin
 * @create 2018/5/26
 */
public class HotTest {
    public static void main(String[] args) throws InterruptedException {
        final Flux<Long> source = Flux.intervalMillis(1000)
                .take(10)
                .publish()
                .autoConnect();
        source.subscribe(System.out::println);
        System.out.println("--------------");
        Thread.sleep(5000);
//        source
//                .toStream()
//                .forEach(System.out::println);
    }
}