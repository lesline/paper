package leader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 主节点选举
 * Created by zhangshaolin on 2017/9/19.
 */
public class LeaderElection {

    //虚拟节点集合
    List<VirtualNote> virtualNotes = new ArrayList<VirtualNote>();

    /**
     * 初始化实体节点
     *
     * @param noteList
     */
    public void init(List<Note> noteList) {
        for (Note note : noteList
                ) {
            if (note.weight == 1) {
                virtualNotes.add(new VirtualNote(note.num, note.getWeight(), 0));
            } else {
                for (int i = 0; i < note.weight; i++) {
                    virtualNotes.add(new VirtualNote(note.num, note.getWeight(), i));
                }
            }
        }
    }

    /**
     * 获取主节点
     *
     * @return
     */
    public Note getLeaderNote() {
        Random random = new Random();
        int i = random.nextInt(virtualNotes.size());
        return virtualNotes.get(i);
    }

    public void setVirtualNotes(List<VirtualNote> virtualNotes) {
        this.virtualNotes = virtualNotes;
    }

    public List<VirtualNote> getVirtualNotes() {
        return virtualNotes;
    }

    /**
     * ip 1 weight 1        1
     * ip 2 weight 2        2  2
     * ip 3 weight 4	      3  3  3  3  3  3  3  3  3
     * ip 12 weight 100	 12 12 12 12 12 12 12 ...
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Note> noteList = new ArrayList<Note>();
        noteList.add(new Note(1, 1));
        noteList.add(new Note(2, 2));
        noteList.add(new Note(3, 4));
        noteList.add(new Note(4, 4));
        noteList.add(new Note(5, 4));
        noteList.add(new Note(6, 4));
        noteList.add(new Note(7, 4));
        noteList.add(new Note(8, 4));
        noteList.add(new Note(9, 4));
        noteList.add(new Note(10, 4));
        noteList.add(new Note(11, 4));
        noteList.add(new Note(12, 4));
        noteList.add(new Note(13, 4));

        for (int i = 14; i < 1000; i++) {
            noteList.add(new Note(i, i));
        }
        LeaderElection leaderElection = new LeaderElection();
        leaderElection.init(noteList);
        System.out.println("所有虚拟节点：" + leaderElection.getVirtualNotes());
        Long start=System.currentTimeMillis();
        for (int i = 0; i <100 ; i++) {
            System.out.println("随机选主节点为：" + leaderElection.getLeaderNote());

        }
        Long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
}
