package reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.UnicastProcessor;
import reactor.test.StepVerifier;

/**
 * @author zhangshaolin
 * @create 2018/5/28
 */
public class TestTest {
    public static void main(String[] args) {
        Flux<String> source = Flux.just("foo", "bar");


        StepVerifier.create((source))
                .expectNext("foo")
                .expectNext("bar")
                .expectErrorMessage("boom")
                .verify();
    }


}