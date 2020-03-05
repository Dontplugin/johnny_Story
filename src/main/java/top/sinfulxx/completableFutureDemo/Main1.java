package top.sinfulxx.completableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main1 {

    /**
     * 主动完成计算
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
//        System.out.println(future.join());
        System.out.println(future.get());
//        System.out.println(future.get(1, TimeUnit.SECONDS));
//        System.out.println(future.getNow(3));

    }*/

    /**
     * 创建CompletableFuture对象
     * @param args
     */
    public static void main(String[] args) {

        CompletableFuture<Integer> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        CompletableFuture<Void> ok = voidCompletableFuture
                .thenRun(() -> System.out.println("运行完成"))
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
