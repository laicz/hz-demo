package com.hz.hzdemo.concurrency.basics;

/**
 * Create by zhoumingbing on 2019-09-17
 */
public class VolatileDemo {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread thread2 = new Thread(() -> {
            b = 1;
            y = a;
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        Thread.sleep(10);

        System.out.println("x=" + x + " y=" + y);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
