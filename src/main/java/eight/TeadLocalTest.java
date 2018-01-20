package eight;

public class TeadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> a=new ThreadLocal<>();
        a.set("zhangshaolin");

        System.out.println(a.get());
    }
}
