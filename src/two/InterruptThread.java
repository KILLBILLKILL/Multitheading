package two;

public class InterruptThread {


    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //
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
                for(int i=0;i<10;i++)
                {
                    //boolean tmp =标志位
                    // 标志位=false
                    // return tmp;
                    // 作用 ： 重置标志位为false，并且返回之前的标志位
                    boolean b=Thread.interrupted();
                    //获取当前的标志位
//                    boolean b= Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });//线程创建的标志位=false

        thread2.start();

       thread2.interrupt();//修改标志位=true

    }
}
