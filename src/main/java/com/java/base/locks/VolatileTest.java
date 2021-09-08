package com.java.base.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by huangxuanfeng on 2021/7/12 下午5:36
 *
 * @author huangxuanfeng
 */
public class VolatileTest {
    private static int counter = 0;
    private static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0; j<10000; j++) {
                        synchronized (VolatileTest.class) {
                            counter ++ ;
                        }
                        ai.getAndAdd(1);
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println("counter=" + counter);
        System.out.println("atomicInteger=" + ai);
    }
}
