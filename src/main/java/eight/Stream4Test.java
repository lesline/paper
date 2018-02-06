package eight;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈stream的高级特性〉
 *
 * @author zhangshaolin
 * @create 2018/1/29
 * @since 1.0.0
 */
public class Stream4Test {
    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args){
        List<Foo> foos = new ArrayList<>();

// create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

// create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

}