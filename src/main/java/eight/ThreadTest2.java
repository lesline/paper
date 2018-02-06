package eight;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈thread〉
 *
 * @author zhangshaolin
 * @create 2018/2/2
 * @since 1.0.0
 */
public class ThreadTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        test2();

    }


    public static void test1() throws InterruptedException, ExecutionException, TimeoutException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };


        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

    }

    public static void test2() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        future.get(1, TimeUnit.SECONDS);
    }
}