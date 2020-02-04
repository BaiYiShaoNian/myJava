package com.keep.me.myTread;

public class ThreadLearn1 extends Thread {
    private int num = 5;

    public void run() {
        for (int i=0; i<10; i++) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + " " + num--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadLearn1 learn1 = new ThreadLearn1();
        ThreadLearn1 learn2 = new ThreadLearn1();
        ThreadLearn1 learn3 = new ThreadLearn1();
        learn1.start();
        learn2.start();
        learn3.start();
    }
}
