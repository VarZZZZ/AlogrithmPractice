package typical.concurrent;

import 笔试.T;

import java.util.concurrent.*;

public class 确保三个线程顺序执行 {

}


// 1. join  比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
class WorkJoin implements Runnable {
    private Thread beforeThread;

    public WorkJoin(Thread beforeThread) {
        this.beforeThread = beforeThread;
    }

    @Override
    public void run() {
        if (beforeThread != null) {
            try {
                beforeThread.join();
                System.out.println("thread start" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("thread start" + Thread.currentThread().getName());
        }
    }
}

class JoinThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new WorkJoin(null));
        Thread t2 = new Thread(new WorkJoin(t1));
        Thread t3 = new Thread(new WorkJoin(t2));
        t1.start();
        ;
        t2.start();
        t3.start();
    }
}

// 2. CountDownLatch  无非就是阻塞一部分线程让其在达到某个条件之后再执行。
class WorkLatch implements Runnable {
    private CountDownLatch pre;
    CountDownLatch cur;

    public WorkLatch(CountDownLatch c1, CountDownLatch c2) {
        this.pre = c1;
        this.cur = c2;
    }

    @Override
    public void run() {
        try {
            pre.await(); // 等到前一个线程减为0；
            System.out.println("thread start" + Thread.currentThread().getName());
            cur.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LatchABCMain {
    public static void main(String[] args) {
        CountDownLatch c0 = new CountDownLatch(0);
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(2);

        Thread t1 = new Thread(new WorkLatch(c0, c1));
        Thread t2 = new Thread(new WorkLatch(c1, c2));
        Thread t3 = new Thread(new WorkLatch(c2, c2));

        t1.start();
        t2.start();
        t3.start();
    }
}

// 阻塞队列
class WorkBlock implements Runnable {

    @Override
    public void run() {
        System.out.println("thread start" + Thread.currentThread().getName());
    }
}

class ThreadBlock {
    public static void main(String[] args) {
        BlockingQueue<Thread> blockingQueue = new LinkedBlockingDeque<>();
        Thread t1 = new Thread(new WorkBlock());
        Thread t2 = new Thread(new WorkBlock());
        Thread t3 = new Thread(new WorkBlock());
        blockingQueue.add(t1);
        blockingQueue.add(t2);
        blockingQueue.add(t3);
        for (int i = 0; i < 3; i++) {
            Thread t = null;
            try {
                t = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
            //检测线程是否还活着
            while (t.isAlive()) ;
        }

    }
}

// newSingleThreadExecutor
class SingleTread{
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
                try {
                    t1.join(10);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
                try {
                    t2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();


        // 或者直接添加sub，不需要执行join;newFixedThreadPoll(1)
    }
}
