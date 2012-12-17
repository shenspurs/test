
public class testsingleton {
	public static class A{
	private int i=0;
	private int k;
	private int m;	
		public A(int j){
			i=j;
			k=0;
			m=0;
		}
		public int geti()
		{
			return i;
		}
	}
	public static class B{
		private static  B b =null;
		private int i=0;	
		private int k =0;
		private int m;
		private B(int j){
			i =j;
			k=0;
			m=0;
		}
		public int geti()
		{
			return i;
		}
		public static B getInstance(int j)
		{
			if (b==null)
				b=new B(j);
			
			return b;
		}
	}

	
		public static void main(String args[]){
			
			
			long t1 = System.currentTimeMillis();
			A a;
			for(int i =0; i<100000000;i++)
			{
				 a=new A(3);
				a.geti();
			}
			long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
			long t3 = System.currentTimeMillis();
			B b = null;
			for(int i =0; i<100000000;i++)
			{
				
				b= B.getInstance(3);
				b.geti();
			}
			long t4 = System.currentTimeMillis();
			System.out.println(t4-t3);
		}
}
