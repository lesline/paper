package eight;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by zhangshaolin on 2018/1/16.
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println( predicate.test("foo")) ;              // true
        System.out.println( predicate.negate().test("foo"));     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(nonNull.test(null));
        System.out.println(isNull.test(null));
        System.out.println(isEmpty.test(""));
        System.out.println(isNotEmpty.test(" "));
    }

}
