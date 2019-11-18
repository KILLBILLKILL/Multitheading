package one;

public class CreatThread {
    public static void main(String[] args) {
        //继承Thread类；
        MyThread t=new MyThread();
        t.start();
        //实现Runnable
       Runnable runner=new MyRunner();
       Thread t2=new Thread(runner);//Runnable tmp=runner;
        t2.start();
        //JavaMain 是JAVA层面的主线程，和main方法中自行创建的
        //线程是同一级别的
        while(true)
        {

        }



    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("in Thread");
        while(true)
        {

        }
    }
}

class MyRunner implements Runnable{
    @Override
    public void run() {
        System.out.println("in runnable");
        while(true)
        {

        }
    }
}


