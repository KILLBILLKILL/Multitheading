package four;

import java.util.ArrayList;
import java.util.List;

public class SafeThread {

    public static int COUNT;

    public static void main(String[] args) throws InterruptedException {
        //开启20个线程，每个线程对COUNT进行++操作10000次
        //预期结果 ；200000
        Object object=new Object();
        for(int i=0;i<20;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++)
                    {
                        //第一种静态类对象锁定
                       //increment();
                        //第二种 对实例对象进行锁定
                       synchronized (object)
                       {
                           COUNT++;
                       }
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>2)
        {
            Thread.yield();
        }

        Thread.sleep(0);

        System.out.println(COUNT);
    }
    public synchronized  static void increment()
    {
        synchronized (SafeThread.class){
            COUNT++;
        }

    }

}
