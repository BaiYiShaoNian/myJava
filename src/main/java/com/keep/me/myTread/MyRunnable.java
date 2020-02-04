package com.keep.me.myTread;

public class MyRunnable implements Runnable {
    private int num = 5;

    public void run() {
        for(int i=0; i<10; i++) {
            if(num > 0) {
                System.out.println(Thread.currentThread().getName() + " " + num--);
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "test");
        Thread thread1 = new Thread(myRunnable, "test1");
        Thread thread2 = new Thread(myRunnable, "test2");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
