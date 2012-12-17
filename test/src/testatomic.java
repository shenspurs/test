import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class testatomic {
	private static int k = 1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final AtomicInteger i = new AtomicInteger(1);
		ExecutorService exec =  Executors.newCachedThreadPool();
		final byte[] lock = new byte[1];
	
		
		for (int j=0; j< 50; j++) {
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					synchronized (lock) {
						System.out.println(Thread.currentThread().getId()+" ------"+k);	
					
						k++;
					}
				
				}
			});
		}
		exec.shutdown();
		
		
		
		
		
	}

}
