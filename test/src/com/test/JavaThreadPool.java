package com.test;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class JavaThreadPool {
    public static void main(String[] args) {

	ExecutorService pool = Executors.newFixedThreadPool(2);

	Thread t1 = new MyThread();
	Thread t2 = new MyThread();
	Thread t3 = new MyThread();
	Thread t4 = new MyThread();
	Thread t5 = new MyThread();

	pool.execute(t1);
	pool.execute(t2);
	pool.execute(t3);
	pool.execute(t4);
	pool.execute(t5);
	pool.shutdown();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + "grg");
    }
}