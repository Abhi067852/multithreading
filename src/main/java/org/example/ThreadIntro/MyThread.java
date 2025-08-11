package org.example.ThreadIntro;

public class MyThread extends Thread{
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(200);
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }

    @Override
    public void run() {
        System.out.println("My thread running");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }
}
