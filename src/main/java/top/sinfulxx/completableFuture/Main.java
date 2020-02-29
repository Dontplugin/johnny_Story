package top.sinfulxx.completableFuture;

import top.sinfulxx.completableFuture.service.Task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java 8 CompletableFuture异步编程使用示例
 */
public class Main {

    private static int a = 300;
    private static int b = 200;

    public static void main(String[] args) {

        try {
            invoke();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void invoke() throws ExecutionException, InterruptedException {
        // 同步调用
        long start = System.currentTimeMillis();
        Task task = new Task();
        System.out.println("开始转账...");
        task.transfer(a, b, 100).get();
        System.out.println("转账完成! 耗时: " + (System.currentTimeMillis() - start));

        long startA = System.currentTimeMillis();
        System.out.println("开始转账...");
        task.transfer(a, b, 50).thenRun(() -> System.out.println("转账完成! 耗时: " + (System.currentTimeMillis() - startA)));
        System.out.println("其他操作...");
    }
}
