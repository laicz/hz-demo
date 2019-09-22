package com.hz.hzdemo.concurrency.basics;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2019-09-13
 */
public class ThreadInterruptedTest {

    @Test
    public void testInterrupted() throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread());
        sleepThread.start();
        Thread.sleep(25000);
        sleepThread.interrupt();
        Thread.sleep(25000);
    }

    class SleepThread implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    System.out.println("I am sleeping thread, this is time " + System.currentTimeMillis() + " i wil sleep 10 seconds");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("I am sleeping thead , but i have happen interruptedException");
                }
            }
        }
    }

}
