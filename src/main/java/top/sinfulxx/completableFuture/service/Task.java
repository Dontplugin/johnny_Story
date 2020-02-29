package top.sinfulxx.completableFuture.service;

import java.util.concurrent.CompletableFuture;

public class Task {

    public CompletableFuture<Void> add(int account, int amount) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        account = account + account;
        System.out.println("金额：" + account + " 操作：" + amount);

        return CompletableFuture.completedFuture(null);
    }

    public CompletableFuture<Void> transfer(int from, int to, int amount) {
        return this.add(from, -amount).thenCompose(v -> this.add(to, amount));
    }
}
