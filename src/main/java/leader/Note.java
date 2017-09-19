package leader;

/**
 * Created by zhangshaolin on 2017/9/19.
 */
public class Note {
    int num;//节点编号
    int weight;//权重

    public Note(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Note{");
        sb.append("num=").append(num);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
