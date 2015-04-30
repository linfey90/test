package test;

public class LocalThreadTest {
    private static int temp = 0;

    public LocalThreadTest(int num) {
        this.temp = num;
    }

    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值  
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    // ②获取下一个序列值  
    public int getNextNum() {
        //        seqNum.set(seqNum.get() + 1);
        //        return seqNum.get();
        return temp++;
    }

    public static void main(String[] args) {
        LocalThreadTest sn = new LocalThreadTest(0);
        // ③ 3个线程共享sn，各自产生序列号  
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private final LocalThreadTest sn;

        public TestClient(LocalThreadTest sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值  
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + this.sn.getNextNum() + "]");
            }
        }
    }
}