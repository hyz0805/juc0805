package com.atguigu.List;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Ticket{
    private  int number = 30;
    private Lock lock = new ReentrantLock();
    public void sale()
    {
        lock.lock();
              try{
                  if(number > 0)
                  {
                      System.out.println(Thread.currentThread().getName()+"\t 卖出第：" +(number--)+"\t 还剩下："+number);
                  }
              }catch(Exception e){
                 e.printStackTrace();
              }finally{
                 lock.unlock();
              }

    }
}
/**
 * @author hyz
 * @create 2019-12-17 10:58
 */
public class SaleTicket {
    public static void main(String[] args)
    {
        Ticket ticket = new Ticket();

        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        new Thread(() -> { for (int i = 1; i <=35 ; i++) ticket.sale();},"A").start();
        new Thread(() -> { for (int i = 1; i <=35 ; i++) ticket.sale();},"B").start();
        new Thread(() -> { for (int i = 1; i <=35 ; i++) ticket.sale();},"C").start();
    }
}
