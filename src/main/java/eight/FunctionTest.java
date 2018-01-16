package eight;

import java.util.function.Function;

/**
 * Created by zhangshaolin on 2018/1/16.
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        toInteger.apply("33");

        System.out.println(toInteger.apply("123").TYPE);      // "123"
        System.out.println(backToString.apply("123"));      // "123"
    }
}
