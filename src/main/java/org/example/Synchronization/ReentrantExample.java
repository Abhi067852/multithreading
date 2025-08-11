package org.example.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ReentrantExample {

    Lock lock =  new ReentrantLock();
    public void outerMethod() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            System.out.println("OuterLock");
            innerMethod();
        }
       finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try {
            System.out.println("InnerLock");

        }
        finally {
            lock.unlock();
        }
    }
}
