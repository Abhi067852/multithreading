package org.example.ThreadMethods;

public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is running");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread= new MyThread();
        thread.start();
        thread.join(); //  this thread will wait this thread is terminated then only it will continue
        System.out.println("Hello");

    }
}
