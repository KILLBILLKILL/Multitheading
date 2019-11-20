package four;

public class SynchronizedTest {

    public synchronized static void method1()
    {
        System.out.println(Thread.currentThread().getName());
        while (true)
        {

        }

    }
    public synchronized static void method2()
    {
        System.out.println(Thread.currentThread().getName());

        while(true)
        {

        }

    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                method2();

            }
        }).start();
    }
}
class MyObject {

    public synchronized void method1(){

        System.out.println(Thread.currentThread().getName());
        while (true)
        {

        }

    }

    public synchronized void method2()
    {
        System.out.println(Thread.currentThread().getName());
        while (true)
        {

        }
    }
}