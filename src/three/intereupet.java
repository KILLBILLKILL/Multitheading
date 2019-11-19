package three;

public class intereupet {
    public static void main(String[] args) throws InterruptedException {
      Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("正在运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
      thread.start();
      Thread.sleep(3000);
      thread.interrupt();
    }
}
