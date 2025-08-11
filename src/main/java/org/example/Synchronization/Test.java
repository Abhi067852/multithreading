package org.example.Synchronization;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//        MyThread t1 = new MyThread(counter);
//        MyThread t2 = new MyThread(counter);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(counter.getCount());



//        // sync
//        BankAccount bankAccount = new BankAccount();
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    bankAccount.withdraw(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//         Thread t1 = new Thread(task,"Thread 1");
//         Thread t2 = new Thread(task,"Thread 2");
//         t1.start();
//         t2.start();



        // Reenterant Lock Example
//        ReentrantExample reentrantExample = new ReentrantExample();
//        reentrantExample.outerMethod();

        // Read write lock

        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {

                    System.out.println(Thread.currentThread().getName() + "Counter : " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName() + "incrementing");
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(readTask,"T1");
        Thread t2 =  new Thread(writeTask,"T2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCount());

    }
}
