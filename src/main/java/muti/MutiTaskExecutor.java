package muti;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author zhangsl
 * @ClassName MutiTaskExecutor
 * @Description 线程池ExecutorService类
 * @date 2016/11/7 16:50
 */
public class MutiTaskExecutor extends ThreadPoolTaskExecutor implements MutiTaskExecutorAPI {
    private String taskName = "默认线程池";//任务名
    private AtomicInteger totalTaskNum = null;//任务总线程数

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public MutiTaskFutures getMutiTaskFutures() {
        totalTaskNum = new AtomicInteger(0);
        return new MutiTaskFutures(this, taskName);
    }

    public Future doSubmit(MutiTask task) {
        task.setTaskId(totalTaskNum.incrementAndGet());
        return this.submit(task);
    }
}
