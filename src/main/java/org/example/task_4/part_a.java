package org.example.task_4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class part_a {
    //Use a CountDownLatch to wait for a set of threads to complete before continuing execution in the main thread.
    public static void main(String[] args) throws InterruptedException {
        int threads = 5;
        CountDownLatch latch = new CountDownLatch(threads);

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executor.submit(() -> {
                try {
                    System.out.println("thread " + Thread.currentThread().getName() + " working");
                    Thread.sleep((int) (Math.random() * ( 3000 - 1000 )));
                    System.out.println("thread " + Thread.currentThread().getName() + " worked out");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        System.out.println("everything worked out well");
        executor.shutdown();
    }
}
