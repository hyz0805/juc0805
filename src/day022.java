/**
 * @author hyz
 * @create 2019-12-15 20:32
 * 1.    高内聚低偶合前提下，线程操作资源类
 * 2.
 * 3.
 */

class AirCondtioner//资源类
{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //1 判断
        while (number != 0){
            this.wait();
        }
        //2 干活
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3 通知
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        //1 判断
        while (number == 0){
            this.wait();
        }
        //2 干活
        --number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3 通知
        this.notifyAll();
        
    }
}
public class day022 {
    public static void main(String[] args)
    {
        AirCondtioner airCondtioner = new AirCondtioner();

        new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                try {
                    airCondtioner.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                try {
                    airCondtioner.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                try {
                    airCondtioner.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                try {
                    airCondtioner.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
