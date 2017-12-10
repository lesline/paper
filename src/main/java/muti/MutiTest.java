package muti;

/**
 * Created by zhangshaolin on 2017/12/10.
 */
public class MutiTest {
        public static void main(String[] args) throws Exception {
            System.out.println("---------------------------start--------------------------");
            MutiTaskServcie mutiTaskServcie = MutiTaskServcie.getInstance("3333");
            for (int i = 0; i < 5; i++) {
                mutiTaskServcie.add(new MutiTask() {
                    public void exec() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread());
                        System.out.println("------正在执行任务---------");
                    }
                });
            }

            mutiTaskServcie.close();

            System.out.println(mutiTaskServcie.isFinished());
            System.out.println("------------------------end---------------------------------");
        }

}
