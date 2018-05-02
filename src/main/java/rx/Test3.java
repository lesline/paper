package rx;

import io.reactivex.Flowable;

public class Test3 {
    public static void main(String[] args) {
       Flowable.just("Hello world").subscribe(System.out::println);

    }
}