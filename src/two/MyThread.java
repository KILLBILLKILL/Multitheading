package two;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("明天要剁手");

            }
        });
        thread.start();
        //不调用join  ,创建线程部分会很耗时间 ，所以下面的代码块会先执行，如果调用join方法，表示thread（线程的引用）会加入
        //当前线程（javaMain主线程)  ，等待thread执行完毕再执行后边的代码
        thread.join();//阻塞方法
        //下面代码常常先执行，因为以上创建线程部分很耗时
        System.out.println("今天还是要上课");
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Thread thread =new Thread(runnable);
//        thread.start();
    }
}
