package org.example.ThreadIntro;

public class Main {

    // one thread starts running automatically
    // this is main thread
    public static void main(String[] args) {
        World world = new World();
        // start method is called to initiate the thread
        world.start();

        // using runnable interface
        //thread object need to be created to start the thread
        WorldRunnable worldRunnable = new WorldRunnable();
        Thread t1  = new Thread(worldRunnable);
        t1.start();

        for(int i=0;i<10000;i++) {
            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        }

    }
}