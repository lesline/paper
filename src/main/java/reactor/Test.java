package reactor;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author zhangshaolin
 * @create 2018/6/6
 */
public class Test {
    public static void main(String[] args) {
//        Mono.fromCallable( () -> System.currentTimeMillis() )
//                .repeat()
//                .parallel(8) //parallelism
//                .runOn(Schedulers.parallel())
//                .subscribe(System.out::println);
//
//
//        System.out.println("--------");



        Integer i=new Integer(6);
        Integer t=new Integer(6);
        System.out.println(i.equals(ExplorationResult.NOT_NEED_REPAIR.value().intValue()));

    }
}