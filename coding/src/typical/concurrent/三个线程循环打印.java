package typical.concurrent;

import javax.swing.*;
import java.util.concurrent.Semaphore;

/**
 * @Author: ly
 * @Date: 2020/7/24 15:28
 * @Version 1.0
 */
public class 三个线程循环打印 {
}

class TaskSemaphore implements Runnable {
    private String str;
    private Semaphore cur;
    private Semaphore next;
    private int times;
    public TaskSemaphore(String str,int times,Semaphore cur,Semaphore next) {
        this.str = str;
        this.cur=cur;
        this.next=next;
        this.times = times;
    }
    @Override
    public void run() {
        for(int i=0;i<times;i++){
            try{
                cur.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
            next.release();
        }
    }

    public static void main(String[] args) {
        Semaphore sa = new Semaphore(1);
        Semaphore sb = new Semaphore(0);
        Semaphore sc = new Semaphore(0);
        new Thread(new TaskSemaphore("A",10,sa,sb)).start();
        new Thread(new TaskSemaphore("B",10,sb,sc)).start();
        new Thread(new TaskSemaphore("C",10,sc,sa)).start();
    }
}
/**
 * 利用lock，for循环掺入一个变量自增，如果i%3=0或i%3=1，输出对应的
 */

