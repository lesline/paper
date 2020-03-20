package reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class SchedulerTest {


    private static String getStringSync() {
        System.out.println("getStringSync");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }

    @Test
    public void test() throws InterruptedException {
        Mono.fromCallable(() -> getStringSync())    // 1
                .subscribe(System.out::println);
        System.out.println("----------");
        Thread.sleep(5000);
    }

    @Test
    public void testSyncToAsync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.fromCallable(() -> getStringSync())    // 1
                .subscribeOn(Schedulers.elastic())  // 2
                .subscribe(System.out::println, null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    @Test
    public void retry1() throws InterruptedException {

        Mono.fromCallable(() -> getStringSync())    // 1
                .map(i -> i.toString().length() / 0)
                .retry(1)
                .subscribe(System.out::println, System.err::println);
        Thread.sleep(100);  // 确保序列执行完
    }

    @Test
    public void retry() throws InterruptedException {

        Flux.range(1, 6)
                .map(i -> 10 / (3 - i))
                .retry(1)
                .subscribe(System.out::println, System.err::println);
        Thread.sleep(100);  // 确保序列执行完
    }
}