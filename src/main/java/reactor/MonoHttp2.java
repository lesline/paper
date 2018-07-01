package reactor;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * @author zhangshaolin
 * @create 2018/6/6
 */
public class MonoHttp2 {
    public static void main(String[] args) throws InterruptedException {
        String param = "param";

        System.out.println("----------------1--------------------");

//        Mono<String> customerPhoneMono = Mono.fromSupplier(
//                () ->  MonoHttp.getItem(param)
//        );
//
        Mono<String> item1Mono = Mono.fromFuture(
                CompletableFuture.supplyAsync(() -> MonoHttp2.getItem(param))
        );
        item1Mono.subscribe(System.out::println);


        Mono<String> item2Mono = Mono.fromFuture(
                CompletableFuture.supplyAsync(() -> MonoHttp2.getItem(param))
        );
        item2Mono.subscribe(System.out::println);


        System.out.println("----------------2--------------------");

        Thread.sleep(1000);

        Mono.zip(item1Mono, item2Mono).map(tuple -> {
            System.out.println("----------------4--------------------");
            String item1 = tuple.getT1();
            String item2 = tuple.getT2();
            return item1 + item2;
        }).block(Duration.ofMillis(3000));


        System.out.println("----------------5--------------------");
        Thread.sleep(50000);
    }

    public static String getItem(String param) {
        try {
            System.out.println("----------------sleep start--------------------");
            Thread.sleep(2000);
            System.out.println("----------------sleep end--------------------");

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return "param=" + param;
    }
}