package reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */

public class Test {

    public void testAppendBoomError() {
        Flux<String> source = Flux.just("foo", "bar");

        StepVerifier.create(
                appendBoomError(source))
                .expectNext("foo")
                .expectNext("bar")
                .expectErrorMessage("boom")
                .verify();
    }

    public <T> Flux<T> appendBoomError(Flux<T> source) {
        return source.concatWith(Mono.error(new IllegalArgumentException("boom")));
    }


}