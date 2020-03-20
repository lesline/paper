package reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class SchedulerTest {


    private String getStringSync() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }
    public static void main(String[] args) {
        Flux.create(sink -> {
            sink.next("【-" + Thread.currentThread().getName() + "-】");
            sink.complete();
        }).
                publishOn(Schedulers.single())
                .map(x -> String.format("[%s]A %s", Thread.currentThread().getName(), x))

                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s]B %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);
    }
}