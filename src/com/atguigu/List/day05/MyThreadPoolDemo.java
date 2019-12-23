package com.atguigu.List.day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hyz
 * @create 2019-12-19 15:00
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try
        {
            for (int i = 1; i <=20 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
