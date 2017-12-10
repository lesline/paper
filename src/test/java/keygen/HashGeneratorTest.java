package keygen;

import hashgen.ConsistentHashGenerator;
import hashgen.HashFunction;
import leader.Note;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangshaolin on 2017/10/31.
 */
public class HashGeneratorTest {

    public static void main(String[] args) {
        asynThreadTest();
    }
    /**
     * 查看hash一致性
     */
    public static void asynThreadTest() {
        Set<String> nodes = new HashSet<String>();
        nodes.add("106.38.115.1");
        nodes.add("106.38.115.2");
        nodes.add("106.38.115.3");

        ConsistentHashGenerator<String> consistentHash = new ConsistentHashGenerator<String>(new HashFunction(), 2, nodes);
        System.out.println("新增节点前： " + consistentHash.getCircle());

        System.out.println(consistentHash.get("/root/app/lock"));
        System.out.println(consistentHash.getHash("/root/app/lock"));
        System.out.println(consistentHash.get("/root/app/dataConfig"));
        System.out.println(consistentHash.getHash("/root/app/dataConfig"));
        Long start=System.currentTimeMillis();

        for (int i = 1; i < 200; i++) {
            consistentHash.add("106.38.115.4");
          //  consistentHash.get("/root/app/lock"+i);
            consistentHash.get("/root/app/dataConfig"+i);
        }
        Long end=System.currentTimeMillis();
        System.out.println(end +" "+start+":"+ (end-start));
    }
    public static void baseTest() {
        Set<String> nodes = new HashSet<String>();
        nodes.add("106.38.115.111");
        nodes.add("106.38.115.2");
        nodes.add("106.38.115.211");
        ConsistentHashGenerator<String> consistentHash = new ConsistentHashGenerator<String>(new HashFunction(), 2, nodes);
        System.out.println("节点信息： " + consistentHash.getCircle());
        consistentHash.testBalance();
    }

    /**
     * 查看hash一致性
     */
    public static void oneThreadTest() {

        Set<String> nodes = new HashSet<String>();
        nodes.add("106.38.115.1");
        nodes.add("106.38.115.2");
        nodes.add("106.38.115.3");

        ConsistentHashGenerator<String> consistentHash = new ConsistentHashGenerator<String>(new HashFunction(), 2, nodes);
        System.out.println("新增节点前： " + consistentHash.getCircle());

        System.out.println(consistentHash.get("/root/app/lock"));
        System.out.println(consistentHash.getHash("/root/app/lock"));
        System.out.println(consistentHash.get("/root/app/dataConfig"));
        System.out.println(consistentHash.getHash("/root/app/dataConfig"));
        Long start=System.currentTimeMillis();

        for (int i = 1; i < 100; i++) {
            consistentHash.add("106.38.115.4");
            System.out.println("新增节点后： " + consistentHash.getCircle());
            System.out.println(consistentHash.get("/root/app/lock"+i));
            System.out.println(consistentHash.get("/root/app/dataConfig"+i));
        }

        Long end=System.currentTimeMillis();

        System.out.println(end +" "+start+":"+ (end-start));
    }

    /**
     * 查看hash一致性
     */
    public static void testConsistent() {
        Set<String> nodes = new HashSet<String>();
        nodes.add("106.38.115.1");
        nodes.add("106.38.115.2");
        nodes.add("106.38.115.3");

        ConsistentHashGenerator<String> consistentHash = new ConsistentHashGenerator<String>(new HashFunction(), 2, nodes);
        System.out.println("新增节点前： " + consistentHash.getCircle());

        System.out.println(consistentHash.get("/root/app/lock"));
        System.out.println(consistentHash.getHash("/root/app/lock"));
        System.out.println(consistentHash.get("/root/app/dataConfig"));
        System.out.println(consistentHash.getHash("/root/app/dataConfig"));
        Long start=System.currentTimeMillis();

        consistentHash.add("106.38.115.4");

        System.out.println(consistentHash.get("/root/app/lock"));
        System.out.println(consistentHash.getHash("/root/app/lock"));
        System.out.println(consistentHash.get("/root/app/dataConfig"));
        System.out.println(consistentHash.getHash("/root/app/dataConfig"));
        Long end=System.currentTimeMillis();

        System.out.println(end +" "+start+":"+ (end-start));
    }
}
