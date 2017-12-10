package muti;


import java.util.concurrent.Future;


/**
 * @author zhangsl
 * @ClassName MutiTaskExecutorAPI
 * @Description 线程池接口
 * @date 2016/11/7 16:50
 */
public interface MutiTaskExecutorAPI {
    /**
     * 获取线程程Futures
     *
     * @return
     */
    public MutiTaskFutures getMutiTaskFutures();

    /**
     * 执行任务
     *
     * @param task
     * @return
     */
    public Future doSubmit(MutiTask task);

}
