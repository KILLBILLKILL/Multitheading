package three;

import java.util.ArrayList;
import java.util.List;

public class UnsafeThread {

    public static int COUNT;

    public static List<Integer> list=new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        //开启20个线程，每个线程对COUNT进行++操作10000次
        //预期结果 ；200000
        for(int i=0;i<20;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++)
                    {
                        COUNT++;
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>2)
        {
            Thread.yield();
        }

        Thread.sleep(10000);

        System.out.println(COUNT);
    }
}
