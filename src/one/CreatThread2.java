package one;

public class CreatThread2 {

    public static void main(String[] args) {
        int num=10;
        MyRunner2 myRunner2=new MyRunner2(num);
        for(int i=0;i<10;i++)
        {
            Thread thread2=new Thread(myRunner2);
            thread2.start();
        }
    }
}

class MyRunner2 implements Runnable{
    private int i;
    public MyRunner2(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i);

    }
}
