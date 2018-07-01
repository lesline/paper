package reactor;

import reactor.core.publisher.Mono;

/**
 * @author zhangshaolin
 * @create 2018/6/6
 */
public class MonoHttp {
    public static void main(String[] args) throws InterruptedException {
        String param = "param";


        System.out.println("----------------1--------------------");

        Mono<String> customerPhoneMono = Mono.fromSupplier(
                () -> MonoHttp.getItem(param)
        );

        customerPhoneMono
//                .timeout(Duration.ofMillis(800))
                .subscribe(System.out::println, e -> System.err.println("dd" + e));

        customerPhoneMono.subscribe(a -> System.out.println("-----订阅一------" + a));
        System.out.println("----------------2--------------------");

        customerPhoneMono.subscribe(a -> System.out.println("-----订阅二------" + a));


        System.out.println("----------------3--------------------");
        Thread.sleep(50000);
    }

    public static String getItem(String param) {
        try {
            System.out.println("----------------sleep start--------------------");
            Thread.sleep(5000);
            System.out.println("----------------sleep end--------------------");

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return "param=" + param;
    }
}