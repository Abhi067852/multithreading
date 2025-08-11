package org.example.Synchronization;

public class Counter {

    private int count = 0;

    //critical section when the resource is getting used by different thread
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
