package typical.concurrent;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer_Consumer {
    //https://www.jianshu.com/p/d0c11dddafa4
    private final static String LOCK = "lock";
    private int count = 0;
    private static final int FULL = 10;


    public static void main(String[] args) {
        Producer_Consumer pc = new Producer_Consumer();
        for (int i = 0; i < 5; i++) {
            new Thread(pc.new Producer(), "生产者-" + i).start();
            new Thread(pc.new Consumer(), "消费者-" + i).start();
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                            ;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者" + Thread.currentThread().getName() + " 总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费者" + Thread.currentThread().getName() + " 共有 " + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}

class ReenTrantLock_Condition {
    private LinkedList<Object> buffer;    //生产者容器
    private int maxSize;           //容器最大值是多少
    private Lock lock;
    private Condition fullCondition;
    private Condition notFullCondition;

    ReenTrantLock_Condition(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<Object>();
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        notFullCondition = lock.newCondition();
    }

    /**
     * 生产者
     *
     * @param obj
     * @throws InterruptedException
     */
    public void put(Object obj) throws InterruptedException {
        lock.lock();    //获取锁
        try {
            while (maxSize == buffer.size()) {
                notFullCondition.await();       //满了，添加的线程进入等待状态
            }
            buffer.add(obj);
            fullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者
     *
     * @return
     * @throws InterruptedException
     */
    public Object get() throws InterruptedException {
        Object obj;
        lock.lock();
        try {
            while (buffer.size() == 0) { //队列中没有数据了 线程进入等待状态
                fullCondition.await();
            }
            obj = buffer.poll();
            notFullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
        return obj;
    }
}

class BlockingQueueDriver {
    public static void main(String[] args) {
        BlockingQueue<Object> que = new ArrayBlockingQueue<>(10);
        class Producer implements Runnable {
            @Override
            public void run() {
                while (true) {
                    try {
                        que.put(new Object());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        class Consumer implements Runnable {
            @Override
            public void run() {
                while (true) {
                    try {
                        que.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new Thread(new Producer()).start();
        ;
        new Thread(new Consumer()).start();
    }
}
