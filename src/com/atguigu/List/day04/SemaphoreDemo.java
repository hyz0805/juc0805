package com.atguigu.List.day04;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author hyz
 * @create 2019-12-17 21:25
 */
public class SemaphoreDemo
{
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1;i<=6; i++){ //模拟6部汽车

            new Thread(() -> {
                boolean flag = false;
                try {
                    semaphore.acquire();
                    flag = true;
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    //暂停几秒
                    try{ TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    if (flag)
                    {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
