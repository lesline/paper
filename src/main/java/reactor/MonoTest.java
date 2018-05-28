package reactor;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author zhangshaolin
 * @create 2018/5/26
 */
public class MonoTest {
    public static void main(String[] args) {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }
}