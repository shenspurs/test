package BackStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class testpoll {
    public static void main(String[] args) {
	// 创建一个可重用固定线程数的线程池
	ExecutorService pool = Executors.newCachedThreadPool();
	// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
	
	Thread t1 = new MyThread();
	Thread t2 = new MyThread();
	Thread t3 = new MyThread();
	Thread t4 = new MyThread();
	Thread t5 = new MyThread();
	Thread t6 = new MyThread();
	Thread t7 = new MyThread();
	Thread t8 = new MyThread();
	Thread t9 = new MyThread();
	Thread t10 = new MyThread();
	// 将线程放入池中进行执行
	pool.submit(t10);
	pool.execute(t1);
	pool.execute(t2);
	pool.execute(t3);
	pool.execute(t4);
	pool.execute(t5);
	pool.execute(t6);
	pool.execute(t7);
	pool.execute(t8);
	pool.execute(t9);
	pool.execute(t10);
	// 关闭线程池
	pool.shutdown();
    }
}
class MyThread extends Thread {
	private static int num=1;
	int cpuNums = Runtime.getRuntime().availableProcessors();
    @Override
    public void run() {
    	
	System.out.println("cpuNums"+cpuNums+Thread.currentThread().getName() + "正在执行。。。"+num+"id-->"+Thread.currentThread().getId());
	num++;
	try {
		sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

    }
}