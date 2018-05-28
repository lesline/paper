package reactor;

import io.reactivex.Flowable;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Random;

public class FluxTest {
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
        reactor.core.publisher.Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        System.out.println("--------generate-------------");
        final Random random = new Random();
        reactor.core.publisher.Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        System.out.println("---------create-----------");
        reactor.core.publisher.Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
}