package top.sinfulxx.atom;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                int count = 1000000;
                while (count-- > 0) {
                    AtomCount.add();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(AtomCount.num);
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}


class AtomCount {
    public static AtomicInteger num = new AtomicInteger(1);

    public static void add() {
        num.addAndGet(1);
    }
}