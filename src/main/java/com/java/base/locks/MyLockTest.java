package com.java.base.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by huangxuanfeng on 2021/3/10 下午6:54
 *
 * @author huangxuanfeng
 */
public class MyLockTest implements Runnable {

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public void get() {
        System.out.println("2 run thread name-->" + Thread.currentThread().getName());
        System.out.println("3 run thread name-->" + Thread.currentThread().getName());
        reentrantLock.lock();
        set();
        reentrantLock.unlock();
        System.out.println("5 run thread name-->" + Thread.currentThread().getName());
    }

    public void set() {
        reentrantLock.lock();
        System.out.println("4 run thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        MyLockTest test = new MyLockTest();
        for (int i=0; i<10; i++) {
            new Thread(test, "thread-" + i).start();
        }
    }
}
