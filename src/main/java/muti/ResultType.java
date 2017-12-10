package muti;

/**
 * Created by zhangshaolin on 2017/12/10.
 */
public enum ResultType {


    FAILED("0", "FAIL"),
    SUCCESS("1", "SUCESS");

    private String code;//执行结果
    private String desc;//执行结果

    ResultType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
