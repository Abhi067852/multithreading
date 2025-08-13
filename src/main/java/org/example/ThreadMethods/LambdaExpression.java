package org.example.ThreadMethods;

public class LambdaExpression {
    public static void main(String[] args) {

        Thread t1 = new Thread(()-> System.out.println("Hello"));
        t1.start();
    }
}
