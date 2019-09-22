package com.hz.hzdemo.base.safe;

import org.junit.Test;

/**
 * 可见性
 * Create by zhoumingbing on 2019-09-13
 */
public class VisableDemo {

    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!stop) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("I am running......");
            }
        }).start();
        Thread.sleep(1000);
        stop = true;
    }

    @Test
    public void atomicTest() throws InterruptedException {
        new Thread(() -> {
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am running......");
            }
        }).start();
        Thread.sleep(1000);
        this.stop = true;
    }

}
