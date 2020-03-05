package top.sinfulxx.atom;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                int count = 1000000;
                while (count-- > 0) {
                    Count.add();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Count.num);
        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}


class Count {
    public static volatile int num = 1;

    public static synchronized void add() {
        num +=1;
    }
}