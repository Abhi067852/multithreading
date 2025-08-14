package org.example.ExecutorImpl;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        int tasks = 5;
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(tasks);

        try {
            for (int i = 1; i <= tasks; i++) {
                final int id = i;
                pool.submit(() -> {
                    try {
                        // Simulate work
                        System.out.println("Task " + id + " started on " + Thread.currentThread().getName());
                        TimeUnit.MILLISECONDS.sleep(300 + id * 100L);
                        System.out.println("Task " + id + " finished");
                        barrier.await();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                });
            }


            System.out.println("All tasks done? ");
        } finally {
            pool.shutdown();
        }
    }
}
