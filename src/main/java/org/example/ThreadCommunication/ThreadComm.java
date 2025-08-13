package org.example.ThreadCommunication;



class SharedResource {
    int data;
    boolean hasData;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        System.out.println("Produced Data :"+value);
        data  = value;
        hasData = true;
        notify();
    }



    public synchronized int consume() throws InterruptedException {
        while (!hasData){
            wait();
        }
        hasData = false;
        notify();
        System.out.println("Consumed Data :"+data);
        return data;
    }
}

class Producer extends Thread {
    SharedResource resource;
    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                resource.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread{
    SharedResource resource;
    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try {
                resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadComm {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Consumer consumer = new Consumer(sharedResource);
        Producer producer = new Producer(sharedResource);
        producer.start();
        consumer.start();
    }
}
