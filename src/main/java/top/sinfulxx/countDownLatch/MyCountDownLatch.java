package top.sinfulxx.countDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanyuzhe
 * @date 2020/3/10 11:36 下午
 * @since 1.0
 */
@Slf4j
public class MyCountDownLatch {

    private volatile AtomicInteger count;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public MyCountDownLatch(int count) {
        this.count = new AtomicInteger(count);

    }

    public void countDown() {
        lock.lock();
        try {
            int i = count.addAndGet(-1);

            log.info("任务剩余数量: {}", i);
            if (i == 0) {
                condition.signalAll();
                log.info("all task has been finished !");
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void await() {
        lock.lock();
        try {
            while (count.get() != 0) {
                condition.await();
                if (count.get() == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            log.error("await interrupted...", e);
        } finally {
            lock.unlock();
        }
    }
}
