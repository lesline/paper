package keygen;

import muti.MutiTask;
import muti.MutiTaskServcie;

/**
 * Created by zhangshaolin on 2017/12/10.
 */
public class HashGenerattorThreadTest {

    public static void main(String[] args) throws Exception {

        System.out.println("---------------------------start--------------------------");

        MutiTaskServcie mutiTaskServcie = MutiTaskServcie.getInstance("3333",5);
        Long start = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            mutiTaskServcie.add(new MutiTask() {
                public void exec() {
                    try {
                        HashGeneratorTest.asynThreadTest();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        mutiTaskServcie.close();

        System.out.println(mutiTaskServcie.isFinished());
        System.out.println("------------------------end---------------------------------");
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


}
