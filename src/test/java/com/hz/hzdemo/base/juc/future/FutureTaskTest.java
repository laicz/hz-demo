package com.hz.hzdemo.base.juc.future;

import java.util.concurrent.*;

/**
 * Create by zhoumingbing on 2019-05-15
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskTest test = new FutureTaskTest();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executorService.execute(test.new Runner());
        }

    }

    private class Runner implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行 ...  ");
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "停止 ...  ");
        }
    }
}
