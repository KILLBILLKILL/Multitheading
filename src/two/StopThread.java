package two;

public class StopThread {

    /*

    是否被中断 ：默认没有被中断
(第二次提交）

     */
    private static volatile boolean myInterrupter;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(myInterrupter)
                {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        Thread.sleep(5000);
        myInterrupter =true;
    }


}
