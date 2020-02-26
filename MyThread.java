import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * 继承Thread类，重写run方法
 */
public class MyThread extends Thread {
    private int pid;
    public MyThread(int pid){
        this.pid=pid;
    }
    public void run(){
        try{
            for(int i=0;i<10;++i) {
                sleep(100);
                System.out.println(String.format("T%d:%d",pid,i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Main{
    public static Object o=new Object();//用于锁
    public static int tt;

    /**
     * 创建线程的三种方法
     *
     */
    public static void newthread(){
        //方法一，继承Thread类，重写run方法
        new MyThread(1).start();

        //方法二，实现runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        //方法三，匿名类继承Thread类，重写run方法
        new Thread("3"){
            public void run(){
                try {
                    sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 为每一个线程分配一个变量finalI，相当于暂缓执行，但是每个线程不共用变量
     */
    public static void finalI(){
        for(int i=0;i<10;i++){
            final int finalI=i;
            new Thread("1"){
                public void run(){
                    try{
                        sleep(1000);
                        System.out.println(String.format("%d",finalI));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    /**
     * 线程共享变量c
     */
    public static int c;
    public static void shareC(){
        for(int i=0;i<10;i++){
            c=i;
            new Thread("2"){
                public void run(){
                    try{
                        sleep(1000);
                        System.out.println(String.format("%d",c));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    /**
     * 设置睡眠时间一样，而第一个线程肯定比第二个线程快一点执行，所以导致了线程1，线程2，线程1，线程2切换
     */
    public static void twothread(){
        new Thread( "1" ) {
            @Override
            public void run() {
                for( int i = 0; i < 10000; ++i ) {
                    try {
                        //影响for循环
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        }.start();
        new Thread( "2" ) {
            @Override
            public void run() {
                for( int i = 0; i < 10000; ++i ) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        }.start();
    }

    /**
     * 用锁实现线程1，线程2，线程1，线程2切换
     * 等待1秒后，一次new两个线程，分别是1，2。
     */
    public static void suo(){
        for(int i=0;i<10;i++) {
            synchronized (o) {
                try {
                    sleep(100);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                new Thread("1") {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                }.start();
                new Thread("2") {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                }.start();
            }
        }
    }

    /**
     * 两个锁，随机执行线程1的锁1或者线程2的锁1，或者线程1的锁2，线程2的锁2.
     * @param i
     */
    public static void synchronized1(int i){
        synchronized (o){
            try{
                sleep(100);
                System.out.println(String.format("T1 %d",i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void synchronized2(int i){
        synchronized (o){
            try{
                sleep(100);
                System.out.println(String.format("T2 %d",i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void Thesynchronized(){
        for(int i=0;i<10;i++){
            final int fi=i;
            new Thread(){
                public void run(){
                    synchronized1(fi);
                    synchronized2(fi);
                }
            }.start();
        }
    }

    /**
     * 线程池
     */
    public static void myExecutor(){
        //SingeleThreadExecutor:谁先提交，谁先执行
        ExecutorService service= Executors.newSingleThreadExecutor();
        service.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<10;i++) {
                        sleep(100);
                        System.out.println("1");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<10;i++) {
                        sleep(100);
                        System.out.println("2");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //FixedThreadPool:指定线程个数，同时执行.如超过，会把当前任务完成，再接指定个数的线程去执行。
        ExecutorService service1=Executors.newFixedThreadPool(2);
        service1.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<10;i++) {
                        sleep(100);
                        System.out.println("1");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        service1.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<10;i++) {
                        sleep(100);
                        System.out.println("2");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        service1.shutdown();
        service1.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<10;i++) {
                        sleep(100);
                        System.out.println("2");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //
    }

    /**
     * Atomic原子操作数类，内部有锁机制，能实现多线程无冲突的自加
     */
    public static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void MyatomicInteger(){
        for(int i=0;i<10;++i){
            new Thread(){
                public void run(){
                    try{
                        sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(String.format("%d",atomicInteger.addAndGet(1)));
                }
            }.start();
        }
    }

    /**
     * 普通操作数存在线程同时对他操作的冲突。比如赋值语句
     */
    public static int count=0;
    public static void MyInteger(){
        for(int i=0;i<10;++i){
            new Thread(){
                public void run(){
                    try{
                        sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(String.format("%d",count++));
                }
            }.start();
        }
    }

    /**
     * Future类接收线程池对象的返回结果，get方法可以得到返回结果
     */
    public static void Myfuture(){
        ExecutorService service=Executors.newSingleThreadExecutor();
        Future<Integer> future=service.submit(new Callable<Integer>() {
            public Integer call() throws Exception{
                sleep(1000);
                return 1;
            }
        });

        try {
            System.out.println(String.format("%d",future.get()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Myfuture();
    }
}

