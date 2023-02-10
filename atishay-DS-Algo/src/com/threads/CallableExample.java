package com.threads;

import java.util.concurrent.*;

/**
 * Understanding difference between Callable and Runnable interface is very imp.
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService exe = Executors.newFixedThreadPool(1);
        PatientTask pat = new PatientTask();
        Future<Integer> result = exe.submit(pat);
        System.out.println(result.get(100, TimeUnit.MILLISECONDS));
    }
}

class PatientTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 30 * 30;
    }
}
