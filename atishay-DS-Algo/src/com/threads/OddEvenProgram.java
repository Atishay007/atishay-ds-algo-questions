package com.threads;

import java.util.concurrent.*;

public class OddEvenProgram {
    private static final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ExecutorService exeServ = Executors.newFixedThreadPool(4);
        exeServ.execute(OddEvenProgram::producer);
        exeServ.execute(OddEvenProgram::producer2);
        //Use of method reference.
        exeServ.execute(OddEvenProgram::dequeueEvenNo);
        exeServ.execute(OddEvenProgram::dequeueOddNo);

        //It is very important to shutdown executorservice otherwise
        //it will keep running.
        exeServ.shutdown();
        try {
            exeServ.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Returns:list of tasks that never commenced execution
        exeServ.shutdownNow();
    }

    private static void producer() {
        for (int i = 0; i < 10; i++) {
            blockingQueue.add(i);
        }
    }

    private static void producer2() {
        for (int i = 10; i < 100; i++) {
            blockingQueue.add(i);
        }
    }

    private static void dequeueEvenNo() {
        while (true) {
            if (blockingQueue.size() > 0 && (blockingQueue.peek() & 1) == 0) {
                System.out.println(blockingQueue.poll());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void dequeueOddNo() {
        while (true) {
            if (blockingQueue.size() > 0 && (blockingQueue.peek() & 1) != 0) {
                System.out.println(blockingQueue.poll());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
