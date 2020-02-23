package top.sinfulxx.master_worker;

/**
 * @author hanyuzhe
 * @date 2020/2/23 5:37 下午
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        Master master = new Master(10);
        master.start();

        for (int i = 0; i < 100; i++) {
            master.submit("任务" + i);
        }
    }
}
