package reactor;

/**
 * 勘查结果
 *
 * @author zsl
 * @date 2018.05.03
 */
public enum ExplorationResult {

    SETTLEMENT(5, "结案"),
    NEED_REPAIR(3, "拆修", true),
    CONTINUE_EXPLORE(4, "继续观察"),
    NOT_NEED_REPAIR(6, "非修回执", true);

    private Byte index;
    private String displayName;
    private Boolean isNew;//是否新增


    private ExplorationResult(int index, String displayName) {
        this.index = (byte) index;
        this.displayName = displayName;
        this.isNew = false;

    }

    private ExplorationResult(int index, String displayName, Boolean isNew) {
        this.index = (byte) index;
        this.displayName = displayName;
        this.isNew = isNew;
    }

    public Byte value() {
        return this.index;
    }

    public String displayName() {
        return displayName;
    }

    public Boolean isNew() {
        return isNew;
    }


}
