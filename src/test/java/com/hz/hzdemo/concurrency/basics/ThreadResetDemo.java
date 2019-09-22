package com.hz.hzdemo.concurrency.basics;

/**
 * Create by zhoumingbing on 2019-09-11
 */
public class ThreadResetDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before reset:" + Thread.currentThread().isInterrupted());
                    System.out.println("after reset:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
