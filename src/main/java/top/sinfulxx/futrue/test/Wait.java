package top.sinfulxx.futrue.test;

/**
 * @author hanyuzhe
 * @date 2020/2/23 3:59 下午
 * @since 1.0
 */
public class Wait {

    public synchronized void scan() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(i);
                Thread.sleep(500);
                if (i == 6) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void ok() {
        notify();
    }
}
