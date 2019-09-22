package com.hz.hzdemo.base.juc.notify;

/**
 * Create by zhoumingbing on 2019-05-20
 */
public class RepairTask {

    public void repaire(Washroom washroom) throws InterruptedException {
        synchronized (washroom.lock) {
            while (!washroom.isAvailable) {
                System.out.println(Thread.currentThread().getName() + " 开始修理 ...... ");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " 修理完成 ...... ");
                washroom.setAvailable();
                washroom.lock.notifyAll();
            }
        }
    }
}
