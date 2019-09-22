package com.hz.hzdemo.base.juc.notify;

/**
 * Create by zhoumingbing on 2019-05-20
 */
public class Washroom {
    /**
     * 浴室是否可用
     */
    public volatile boolean isAvailable = false;

    public final Object lock = new Object();

    public void wash() throws InterruptedException {
        synchronized (this.lock) {
            while (!isAvailable) {
                this.lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + " 开始 ..... ");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " 结束  ..... ");
            lock.notifyAll();
        }
    }

    public void setAvailable() {
        this.isAvailable = true;
    }
}
