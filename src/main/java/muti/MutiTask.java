package muti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author zhangsl
 * @ClassName MutiTask
 * @Description 线程类，具体逻辑实现时要实现该抽象类
 * @date 2016/11/5 14:16
 */
public abstract class MutiTask implements Callable<TaskResult> {
    private static Logger logger = LoggerFactory.getLogger(MutiTaskServcie.class);

    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public TaskResult call() {
        logger.debug("开始执行[线程ID={}]线程", taskId);
        TaskResult taskResult = TaskResult.getSuccessInstance(this.getTaskId());
        try {
            exec();
        } catch (Exception e) {
            logger.error("执行定时任务出错：", e);
            taskResult.setException(e);
        }
        logger.debug("执行线程{}结束", taskResult.toPrint());
        return taskResult;
    }

    public abstract void exec();
}


