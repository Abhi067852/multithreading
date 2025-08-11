package org.example.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    int count = 0;

    ReadWriteLock lock = new ReentrantReadWriteLock();


    public void increment() {
        lock.writeLock().lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int getCount(){

        lock.readLock().lock();
        try {
            return count;
        }
        finally {
            lock.readLock().unlock();
        }

    }
}
