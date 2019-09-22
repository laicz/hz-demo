package com.hz.hzdemo.base.juc.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by zhoumingbing on 2019-05-20
 */
public class NotifyTest {
    public static void main(String[] args) {
        Washroom washroom = new Washroom();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    washroom.wash();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    washroom.wash();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    washroom.wash();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {
            try {
                new RepairTask().repaire(washroom);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
