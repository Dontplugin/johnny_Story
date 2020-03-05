package top.sinfulxx.synchronize;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author hanyuzhe
 * @date 2020/2/25 5:05 下午
 * @since 1.0
 */
public class Main {
    private int k = 0;

    public int getK() {
        return k;
    }
    public synchronized int getOk() {
        return k;
    }

    public synchronized void add() {
        k++;
    }

    public static void main(String[] args) {
        final Main main = new Main();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    main.add();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    main.add();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    main.add();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        while (true) {
            try {
                Thread.sleep(100);
                if (ObjectUtil.compare(main.getK(), main.getOk()) != 0) {
                    System.out.println("一般: " + main.getK() + " 加锁: " + main.getOk());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
