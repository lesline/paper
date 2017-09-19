package leader;

/**
 * ip 1 weight 1        1
 * ip 2 weight 2        2  2
 * ip 3 weight 4	      3  3  3  3  3  3  3  3  3
 * ip 12 weight 100	 12 12 12 12 12 12 12 ...
 * <p>
 * Created by zhangshaolin on 2017/9/19.
 */

public class VirtualNote extends Note {
    int index;//节点下标

    public VirtualNote(int num, int weight, int index) {
        super(num, weight);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VirtualNote{");
        sb.append("num=").append(num);
        sb.append(", weight=").append(weight);
        sb.append(", index=").append(index);
        sb.append('}');
        return sb.toString();
    }
}
