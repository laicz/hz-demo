package com.hz.hzdemo.base.safe;

/**
 * 当多个线程同时对int 做++ 操作，会出现并发问题
 * 使用volatile并不会解决原子性操作问题，这只是增加属性的可见性
 * Create by zhoumingbing on 2019-09-13
 */
public class AtomicDemo {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new AtomicDemo().new CountThread()).start();
        }
        Thread.sleep(1000);
        System.out.println("运算结果：" + count);
    }

    class CountThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

}
