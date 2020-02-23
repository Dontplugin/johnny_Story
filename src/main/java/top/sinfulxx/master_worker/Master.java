package top.sinfulxx.master_worker;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author hanyuzhe
 * @date 2020/2/23 5:17 下午
 * @since 1.0
 */
public class Master {

    private static Map<String, Thread> workerMap = Maps.newConcurrentMap();
    private static Queue<Object> tasks = new ConcurrentLinkedDeque<>();
    private static Queue<Object> results = new ConcurrentLinkedDeque<>();

    private int workNum;

    public Master(int workNum) {
        this.workNum = workNum;

        for (int i = 0; i < workNum; i++) {
            workerMap.put(String.valueOf(i), new Thread(new Worker(tasks, results), String.valueOf(i)));
        }
    }


    public void submit(Object task) {
        tasks.add(task);
    }


    public void start() {
        for (String s : workerMap.keySet()) {
            Thread worker = workerMap.get(s);
            worker.start();
        }
    }
}
