package top.sinfulxx.futrue;

import top.sinfulxx.futrue.data.Data;
import top.sinfulxx.futrue.data.JdkFutureData;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hanyuzhe
 * @date 2020/2/23 3:40 下午
 * @since 1.0
 */
public class JdkFutureMain {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new JdkFutureData("ok"));
        ExecutorService executorService = new ThreadPoolExecutor(1, 5, 1000L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(10));

        executorService.submit(futureTask);
        System.out.println("请求结束, 开始处理其他业务逻辑");

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("请求结果数据: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
