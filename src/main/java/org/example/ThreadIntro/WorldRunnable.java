package org.example.ThreadIntro;

public class WorldRunnable implements Runnable{

        @Override
        public void run() {

            // run method is to define the implementation of thread
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getName());
            }
        }


}
