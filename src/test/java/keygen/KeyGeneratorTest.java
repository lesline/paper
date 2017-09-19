package keygen;

/**
 * Created by zhangshaolin on 2017/9/18.
 */
public class KeyGeneratorTest {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new SnowflakeKeyGenerator();
        SnowflakeKeyGenerator.setWorkerId(1);
        System.out.println(keyGenerator.generateKey());

        System.out.println(keyGenerator.generateKeyByBatch());

    }
}
