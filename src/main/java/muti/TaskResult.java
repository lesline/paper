package muti;


/**
 * @author zhangsl
 * @ClassName TaskResult
 * @Description 线程结果类
 * @date 2016/8/29 11:45
 */
public final class TaskResult {
    private int taskId;//线程ID
    private String code;//执行结果
    private Exception exception;//异常信息

    private TaskResult() {
        super();
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        setCode(ResultType.FAILED.getCode());
        this.exception = exception;
    }

    public static TaskResult getSuccessInstance(int taskId) {
        TaskResult taskResult = new TaskResult();
        taskResult.setTaskId(taskId);
        taskResult.setCode(ResultType.SUCCESS.getCode());
        return taskResult;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TaskResult{");
        sb.append("taskId=").append(taskId);
        sb.append(", code='").append(code).append('\'');
        sb.append(", exception=").append(exception);
        sb.append('}');
        return sb.toString();
    }

    public String toPrint() {
        return "[" +
                "线程ID='" + taskId + '\'' +
                ", 结果编码='" + code + '\'' +
                ", 异常信息='" + exception + '\'' +
                ']';
    }
}
