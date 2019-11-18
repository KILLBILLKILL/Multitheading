package one;

public class Sequence {

    public static void main(String[] args) {
        //启动0到9的十个线程，每个线程打印他的编号
        for(int i=0;i<10;i++) {
            final int b=i;
            Runnable r = new Runnable() {
                @Override
                public void run() {


                    try {
                        Thread.sleep(1000*b);
                        System.out.println(b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            Thread t = new Thread(r);
            t.start();
        }

    }
}
