package com.atguigu.List.day04;

import java.util.concurrent.CountDownLatch;

/**
 * @author hyz
 * @create 2019-12-17 21:16
 */
public class CountDownLatchDemo
{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1;i<=6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t 班长离开教室");
    }
}
