package thread;

import bean.Person;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangshaolin
 * @create 2018/8/10
 */
public class Test {
    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executor2 = Executors.newFixedThreadPool(10);

        for (int i = 0; i <100000 ; i++) {
            executor.submit(() -> {
                person.reset();
                person.set2();



            });
            executor2.submit(() -> {
                Integer a = person.get();
                if (a != 1) {
                    System.out.println(a);
                }

            });
        }




    }
}