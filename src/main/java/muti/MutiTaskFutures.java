package muti;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


/**
 * @author zhangsl
 * @ClassName MutiTaskFutures
 * @Description 线程池ExecutorService类
 * @date 2016/11/7 16:50
 */
public class MutiTaskFutures {
    private static Logger logger = LoggerFactory.getLogger(MutiTaskFutures.class);
    private List<Future<TaskResult>> futures = new ArrayList();
    MutiTaskExecutorAPI mutiTaskExecutorAPI;
    private String taskName;

    private MutiTaskFutures() {
    }

    public MutiTaskFutures(MutiTaskExecutorAPI mutiTaskExecutorAPI, String taskName) {
        this.mutiTaskExecutorAPI = mutiTaskExecutorAPI;
        this.taskName = taskName;
    }

    /**
     * 增加任务并执行
     *
     * @param task
     * @throws Exception
     */
    public synchronized void add(MutiTask task) {
        futures.add(mutiTaskExecutorAPI.doSubmit(task));
    }

    /**
     * 检查执行结果：如果线程池中有线程出错，抛出异常(抛出第一个异常）
     */
    public void close() throws Exception {
        TaskResult taskResultWithException = null;
        for (Future<TaskResult> future : futures) {
            TaskResult taskResult = future.get();
            logger.info("线程池[{}] >>> 执行结果:{}", taskName, taskResult.toPrint());
            if (ResultType.FAILED.getCode().equals((taskResult.getCode()))) {
                taskResultWithException = taskResultWithException == null ? taskResult : taskResultWithException;
            }
        }
        if (taskResultWithException != null) {
            throw taskResultWithException.getException();

        }
    }
}
