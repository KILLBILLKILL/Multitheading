package two;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadAdvantage {

    /*
    集合：
    Collection   / list
               ArrayList
               linkedList
               Set: HashSet TreeSet


     Map       HashMap TreeMap
     */
    public static List<String> randomList()
    {
        char[] chars={'a','b','c','z','a','z'};
        List<String> list=new LinkedList<>();
        for(int i=0;i<100000;i++)
        {
           int random= new Random().nextInt(chars.length);
           char c=chars[random];
           list.add(String.valueOf(c));
        }
        return list;
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> list=randomList();
        //创建十个线程 每个线程获取List中的10000个元素，
        //时间Data  java.util.Data
        //jdk1.8->LocalDateTime
        long start = System.currentTimeMillis();
        Thread[] threads =new Thread[10];
//        long start =new Date().getTime();
        for(int i=0;i<10;i++)
        {
            final  int k=i;

            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        list.get(k * 10000 + j);
                    }
              }
            },"我的线程"+k);
            System.out.println(threads[i].getName());
            threads[i].start();
            }
        //第一种做法 线程让步 ：
//        while(Thread.activeCount()>2)
////        {
////            Thread.yield();
////        }
        //第二种做法 调用线程加入/等待操作 join
        for(Thread thread : threads)
        {

            thread.join();
        }
        long end=System.currentTimeMillis();
        System.out.println("耗时: "+(end - start)+ "毫秒");
        }
    }

