package top.sinfulxx.test;

/**
 * @author hanyuzhe
 * @date 2020/4/7 12:37 上午
 * @since 1.0
 */
public class Main {
    private static Main main1 = new Main();
    private static Main main2 = new Main();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (main1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (main2) {
                    System.out.println("ok");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (main2) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (main1) {
                    System.out.println("fine");
                }
            }
        }).start();
    }


}
