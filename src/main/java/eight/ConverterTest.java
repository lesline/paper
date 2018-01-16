package eight;

/**
 * Created by zhangshaolin on 2018/1/16.
 */
public class ConverterTest {
    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        Converter<String, Integer> converter = (from) -> (Integer.valueOf(from));
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    public static void test2() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    public static void test3() {
         int num = 1;
        Converter<Integer, String> converter = (from)->String.valueOf(from+num);
        String converted = converter.convert(1);
        System.out.println(converted);   // 123
    }
}
