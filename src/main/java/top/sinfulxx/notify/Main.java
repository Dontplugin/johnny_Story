package top.sinfulxx.notify;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author hanyuzhe
 * @date 2020/2/25 8:13 下午
 * @since 1.0
 */
public class Main {

    protected List<String> list = Lists.newArrayList();


    private synchronized boolean check(String a, String b) {
        while (list.contains(a) || list.contains(b)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("进入了: " + Thread.currentThread().getName());
        list.add(a);
        list.add(b);

        return true;
    }

    private synchronized void free(String a, String b) {
        list.remove(a);
        list.remove(b);

        notify();
    }

    static class Task implements Runnable {
        private Main main;
        public Task(Main main) {
            this.main = main;
        }

        @Override
        public void run() {
            main.check("a", "b");
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        Thread thread = new Thread(new Task(main), "1");

        main.list.add("a");
        main.list.add("b");

        thread.start();
        main.free("a", "b");

        try {
            Thread.sleep(1000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


