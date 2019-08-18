package test.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class test1 {
    /**
     * 实现 Runnable 接口
     */
    public static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("实现 Runnable 接口，线程");
            // ...
        }
    }

    /**
     * 实现 Callable 接口
     */
    public static class MyCallable implements Callable<Integer> {
        public Integer call() {
            System.out.println("实现Callable");
            return 123;
        }
    }


    /**
     *继承thread类
     */
    public static class MyThread extends Thread {
        public void run() {
            // ...
            System.out.println("继承thread类");
        }
    }
    public static void main(String[] args) throws Exception{
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
        for(int i=0;i<10;i++){
            Thread thread1 = new Thread(instance);
            thread1.start();
        }

        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());

        MyThread mt = new MyThread();
        mt.start();
        /**
         * Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
         *
         * 主要有三种 Executor：
         *
         * CachedThreadPool：一个任务创建一个线程；
         * FixedThreadPool：所有任务只能使用固定大小的线程；
         * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
