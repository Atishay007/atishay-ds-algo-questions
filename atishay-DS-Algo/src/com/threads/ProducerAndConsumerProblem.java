package com.threads;

import java.util.concurrent.*;

/*
Using LinkedBlockingQueue which internally handles lock and unlock mechanism for
the threads.
 */
public class ProducerAndConsumerProblem {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
        Producer producer = new Producer(bq);
        Consumer consumer = new Consumer(bq);

        ExecutorService exeServ = Executors.newFixedThreadPool(2);
        exeServ.execute(() -> producer.run());

        exeServ.execute(() -> consumer.run());

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
}

class Producer implements Runnable {
    private BlockingQueue<Integer> bq = null;

    public Producer(BlockingQueue<Integer> bq) {
        System.out.println("Producer Initialized");
        this.bq = bq;
    }

    @Override
    public void run() {
        System.out.println("Producer Started");
        for (int i = 0; i < 200000; i++) {
            bq.offer(i);
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> bq = null;

    public Consumer(BlockingQueue<Integer> bq) {
        System.out.println("Consumer Initialized");
        this.bq = bq;
    }

    @Override
    public void run() {
        System.out.println("Consumer Started");
        while (true) {
            try {
                System.out.println(bq.poll());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}