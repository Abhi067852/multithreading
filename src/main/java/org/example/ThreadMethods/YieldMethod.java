package org.example.ThreadMethods;

import java.util.Timer;

public class YieldMethod extends Thread{

    public YieldMethod(String name) {
        super(name);
    }

    @Override
    public void run() {

//        for(int i=0;i<5;i++){
//            System.out.println(Thread.currentThread().getName());
//            Thread.yield();
//        }

        while(true) {
            System.out.println("Hellow world");
        }

    }

    public static void main(String[] args) {
        YieldMethod t1  = new YieldMethod("t1");
        YieldMethod t2 = new YieldMethod("t2");
        t1.setDaemon(true);
        t1.start();

        t2.start();


    }
}
