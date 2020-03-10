package top.sinfulxx.countDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hanyuzhe
 * @date 2020/3/10 11:35 下午
 * @since 1.0
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        MyCountDownLatch countDownLatch = new MyCountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000L);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        log.info("开始执行线程任务");
        countDownLatch.await();

        log.info("ok");
    }

}