package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

    public static void main(String[] args) {
        int threadSize = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            TestThread t = new TestThread(latch, i + "");
            executor.execute(t);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaaaaaaaaaaa");
        executor.shutdown();
        System.exit(0);
    }
}

class TestThread implements Runnable {

    String t;
    CountDownLatch latch;

    public TestThread(CountDownLatch latch, String t) {
        this.latch = latch;
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("线程" + this.t + "开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + this.t + "结束");
        this.latch.countDown();//工人完成工作，计数器减一
    }

}
