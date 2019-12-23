package com.atguigu.List.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache
{
    private volatile Map<String,String> map = new HashMap<>();
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void put(String key,String value)
    {
        rwl.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入结束");
        }finally{
            rwl.writeLock().unlock();
        }
    }
    public void get(String key)
    {
        rwl.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 读取开始");

            String result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取结束"+result);
        }finally{
            rwl.readLock().unlock();
        }
    }
   /* private Lock lock = new ReentrantLock();

    public void put(String key,String value)
    {
        lock.lock();
              try{
                  System.out.println(Thread.currentThread().getName()+"\t 写入开始");
                  map.put(key,value);
                  System.out.println(Thread.currentThread().getName()+"\t 写入结束");
              }finally{
                 lock.unlock();
              }

    }
    public void get(String key) {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 读取开始");

            String result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取结束"+result);
        }finally{
            lock.unlock();
        }
    }*/
}
/**
 * @author hyz
 * @create 2019-12-17 20:08
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <=10 ; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCache.put(tempI+" ",tempI+" ");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=10 ; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCache.get(tempI+" ");
            },String.valueOf(i)).start();
        }


    }
}
