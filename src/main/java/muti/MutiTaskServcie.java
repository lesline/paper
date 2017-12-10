package muti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author zhangsl
 * @ClassName MutiTaskServcie
 * @Description 线程池ExecutorService类
 * @date 2016/11/7 16:50
 */
public final class MutiTaskServcie {
    private static Logger logger = LoggerFactory.getLogger(MutiTaskServcie.class);
    private final static int DEFAULT_NUM_THREAD = 10;//默认线程池大小
    private final static String DEFAULT_TASK_NAME = "default task";
    private final static boolean DEFAULT_IS_CLOSENOW_IF_EXCEPTION = false;
    private final static boolean DEFAULT_IS_CAT_OPEN = false;

    private String taskName;//任务名
    private boolean isCloseNowIfException;//有一个线程失败，立刻关闭线程池
    private boolean isCatOpen;//是否打开线程监控

    private ExecutorService executor;
    private CompletionService<TaskResult> completionService;

    private List<Future<TaskResult>> futures = new ArrayList();
    private AtomicInteger totalTaskNum = new AtomicInteger(0);//总线程数

    private MutiTaskServcie initInstance(String taskName, int numThread, boolean isCloseNowIfException, boolean isCatOpen) {
        this.taskName = taskName;
        this.isCloseNowIfException = isCloseNowIfException;
        this.isCatOpen = isCatOpen;
        executor = Executors.newFixedThreadPool(numThread);
        completionService = new ExecutorCompletionService<TaskResult>(executor);
        return this;
    }

    private MutiTaskServcie() {
        initInstance(DEFAULT_TASK_NAME, DEFAULT_NUM_THREAD, DEFAULT_IS_CLOSENOW_IF_EXCEPTION, DEFAULT_IS_CAT_OPEN);
    }

    private MutiTaskServcie(String taskName, int numThread, boolean isCloseNowIfException, boolean isCatOpen) {
        initInstance(taskName, numThread, isCloseNowIfException, isCatOpen);
    }

    public static MutiTaskServcie getInstance() {
        return new MutiTaskServcie();
    }

    public static MutiTaskServcie getInstance(String taskName) {
        return new MutiTaskServcie(taskName, DEFAULT_NUM_THREAD, DEFAULT_IS_CLOSENOW_IF_EXCEPTION, DEFAULT_IS_CAT_OPEN);
    }

    public static MutiTaskServcie getInstance(String taskName, int numThread) {
        return new MutiTaskServcie(taskName, numThread, DEFAULT_IS_CLOSENOW_IF_EXCEPTION, DEFAULT_IS_CAT_OPEN);
    }

    public static MutiTaskServcie getInstance(String taskName, int numThread, boolean isCloseNowIfException) {
        return new MutiTaskServcie(taskName, numThread, isCloseNowIfException, DEFAULT_IS_CAT_OPEN);
    }

    public static MutiTaskServcie getInstance(String taskName, int numThread, boolean isCloseNowIfException, boolean isCatOpen) {
        return new MutiTaskServcie(taskName, numThread, isCloseNowIfException, isCatOpen);
    }

    /**
     * 增加任务
     *
     * @param task
     * @throws Exception
     */
    public void add(MutiTask task) throws Exception {
        task.setTaskId(totalTaskNum.incrementAndGet());
        try {
            futures.add(completionService.submit(task));
        } catch (Exception e) {
            totalTaskNum.decrementAndGet();
            executor.shutdownNow();
            throw e;
        }
    }

    /**
     * 关闭服务，并等待服务内的线程执行完成
     *
     * @throws Exception
     */
    public void close() throws Exception {

        if (!executor.isShutdown()) {
            //关闭线程池
            executor.shutdown();
            //新启一个线程监控线程执行结果
            catResultAndCloseNowIfException();
            //等待线程结束
            waitAllToStop();
            //检查执行结果：如果线程池中有线程出错，抛出异常
            checkResult();
        }
    }

    /**
     * 等待线程结束
     *
     * @throws InterruptedException
     */
    private void waitAllToStop() throws InterruptedException {
        while (!executor.isTerminated()) {
            executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
        }
    }

    public boolean isFinished() {
        return executor.isTerminated();
    }

    /**
     * 新启一个线程监控线程执行结果
     */
    private void catResultAndCloseNowIfException() {
        if (isCloseNowIfException | isCatOpen) {
            new Thread("监控线程池执行结果") {
                public void run() {
                    for (int i = 0; i < totalTaskNum.get(); i++) {
                        try {
                            TaskResult taskResult = completionService.take().get();
                            if (isCatOpen) {
                                logger.info("多线程执行定时任务[{}] >>> 执行结果:{}", taskName, taskResult.toPrint());
                            }
                            if (isCloseNowIfException) {
                                if (ResultType.FAILED.getCode().equals((taskResult.getCode()))) {
                                    logger.error("有一个线程失败，立刻关闭线池！");
                                    executor.shutdownNow();
                                }
                            }
                        } catch (Exception e) {
                            logger.error("监控到线程池内异常", e);
                            break;
                        }
                    }
                }
            }.start();
        }
    }
    /**
     * 检查执行结果：如果线程池中有线程出错，抛出异常
     */
    public void checkResult() throws Exception {
        for (Future<TaskResult> future : futures) {
            TaskResult taskResult = future.get();
            if (ResultType.FAILED.getCode().equals((taskResult.getCode()))) {
                throw taskResult.getException();
            }
        }
    }
}
