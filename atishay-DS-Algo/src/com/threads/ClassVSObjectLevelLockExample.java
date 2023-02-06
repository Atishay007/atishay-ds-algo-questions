package com.threads;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
This example proves that Class level lock and Object level lock are totally independent.
Class level lock should be used only when we need to update static variable or some
operation that should be done by only 1 thread at class level.
 */
public class ClassVSObjectLevelLockExample {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(7);
        Payment payObect = new Payment();
        exe.submit(() -> payObect.getPaymentMethods());
        exe.submit(() -> payObect.getPaymentMethods2());
        exe.submit(() -> payObect.getPaymentMethods());
        exe.submit(() -> payObect.updatePaymentModes());
        exe.submit(() -> payObect.updatePaymentModes2());
        exe.submit(() -> payObect.updatePaymentModes());
        exe.shutdown();

        try {
            if (!exe.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("Time elapsed, shutting down ExecutorService forcefully.");
            }
            exe.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
