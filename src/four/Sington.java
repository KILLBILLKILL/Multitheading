package four;

import java.lang.ref.PhantomReference;

public class Sington {
    //饿汉式写法
    private static final Sington SINGTON =new Sington();
    public static Sington getInstance(){

        return SINGTON;
    }

    //懒汉式写法
    private static Sington SINGTON2=null;

    public static Sington getInstance2()
    {
        if(SINGTON2==null)
        {
            SINGTON2=new Sington();
        }
        return SINGTON2;
    }
    private Sington()
    {


    }
    public static void main(String [] args)
    {
        for(int i=0;i<10;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Sington.getInstance2();

                }
            }).start();
        }
    }

}
