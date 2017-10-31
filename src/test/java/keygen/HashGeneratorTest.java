package keygen;

import hashgen.ConsistentHashGenerator;
import hashgen.HashFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangshaolin on 2017/10/31.
 */
public class HashGeneratorTest {

    public static void main(String[] args) {
        testConsistent();
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

        consistentHash.add("106.38.115.4");
        System.out.println("新增节点后： " + consistentHash.getCircle());

        System.out.println(consistentHash.get("/root/app/lock"));
        System.out.println(consistentHash.getHash("/root/app/lock"));
        System.out.println(consistentHash.get("/root/app/dataConfig"));
        System.out.println(consistentHash.getHash("/root/app/dataConfig"));

    }
}
