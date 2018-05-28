package reactor;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class TestTest {
    public static void main(String[] args) {
        StepVerifier.create(Flux.just("a", "b"))
                .expectNext("a")
                .expectNext("b")
                .verifyComplete();
    }
}