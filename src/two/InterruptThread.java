package two;

public class InterruptThread {


    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        thread.interrupt();


        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
               while(true)
               {


               }
            }
        });

        thread2.start();

        thread2.interrupt();

    }
}
