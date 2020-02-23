package top.sinfulxx.master_worker;

import cn.hutool.json.JSONUtil;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hanyuzhe
 * @date 2020/2/23 5:28 下午
 * @since 1.0
 */
public class Worker implements Runnable{

    private Queue<Object> tasks = new ConcurrentLinkedDeque<>();
    private Queue<Object> results = new ConcurrentLinkedDeque<>();
    private AtomicInteger count = new AtomicInteger(0);
    private boolean isStop = false;

    public Worker(Queue<Object> tasks, Queue<Object> results) {
        this.tasks = tasks;
        this.results = results;
    }

    @Override
    public void run() {
        while (!isStop) {
            Object poll = tasks.poll();
            if (poll != null) {
                System.out.println("开始执行: " + JSONUtil.toJsonStr(poll));

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String name = Thread.currentThread().getName();
                String result = "任务执行完成" + name + " : " + count.addAndGet(1);
                System.out.println(result);
                results.add(result);
            }
        }
    }
}
