package org.example.ExecutorImpl;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            int finalI = i;
            Future<Integer> future  = executorService.submit(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return finalI;

            });
            System.out.println(future.get(10000,TimeUnit.MILLISECONDS));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time");
        System.out.println(System.currentTimeMillis()-startTime);

    }
}
