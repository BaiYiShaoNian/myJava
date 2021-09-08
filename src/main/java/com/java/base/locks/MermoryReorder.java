package com.java.base.locks;

/**
 * Create by huangxuanfeng on 2021/7/12 下午5:20
 *
 * @author huangxuanfeng
 */
public class MermoryReorder {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; ; i++) {
            x = 0; y = 0;
            a = 0; b = 0;

            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start(); two.start();
            one.join(); two.join();

            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次（" + x + ", " + "y" + "）");
                break;
            }
        }
    }
}
