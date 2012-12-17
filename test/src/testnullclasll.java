
public class testnullclasll {

	
	
	
	public class B
	{
	
		private int a;
		public  B()
		{
			
		}
		
		public void setA(int index)
		{
			a=index;
		}
		
		public int getA()
		{
			return a;
		}
	}
	public static class A
	{
		private int a;
		private B b;
		public  A(int s)
		{
			a =s;
		}
		public void setA(int index)
		{
			a=index;
		}
		
		public int getA()
		{
			return a;
		}
		
		
		public B getB()
		{
			return b;
		}
	}
	
	
	
	
	public static  void main(String[] args)
	{
		int s =3;
		A a = new A(s);
		int b=a.getB()!=null?a.getB().getA():3;
		System.out.println(b);
		
	}
	
	

	
}
