import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class test {
	
	
static class A{
	private int a;
	public A(int i) {
		// TODO Auto-generated constructor stub
		a=i;
	}
	public int mA()
	{return a;}
	
}
	public static void main(String[] args) throws Exception, NoSuchFieldException {
	
		boolean print =true;
		A ma = new A(3);
		long t1 = System.currentTimeMillis();
		for (int i =0; i<1000000000;i++)
		{
			if(print){
				System.out.println("a="+ma.mA()+ma.getClass().getCanonicalName());
				print=false;
				}
			else
				ma.mA();
			
			
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		print=true;
//		long t3 = System.currentTimeMillis();
//		for (int i =0; i<10000000;i++)
//		{	
//			if(print){
//				Field field = (Field) ma.getClass().getDeclaredField("a");
//				field.setAccessible(true);
//				System.out.println("a="+(field.get(ma)));
//			}
//			else
//				ma.getClass().getDeclaredField("a");
//			print=false;
//		}
//		
//		long t4 = System.currentTimeMillis();
//		System.out.println(t4-t3);
//		System.out.println((t4-t3)/(t2-t1));
		long t5 = System.currentTimeMillis();
		for (int i =0; i<1000000000;i++)
		{	
			
		}
		long t6 = System.currentTimeMillis();
		System.out.println(t6-t5);
		
		
		
		
		
		

		List<String> list = new ArrayList<String>();
		list.add("test");
		list.size();
		((ArrayList<String>) list).trimToSize();
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("test");
		arraylist.trimToSize();
		System.out.println("1");
		
		
		String keysSequence= "12345678";
		final String[] keys = keysSequence.split(" ");
		
		
		String test = "";
		System.out.println(test.indexOf("insdgkljdgljdslgk"));
		
		test ="he.co.m";
		System.out.println(test.matches("he\\.co\\.m"));
		int a[]={1,2,3,4,5};
		System.out.println(a);
		Byte s = new Byte((byte) -14);
		
		System.out.println((int)s);
		
		System.out.println(Utf8URLencode("nihao你好：%20"));
		

		System.out.println(testtitle("《&quot;你好》&quot; 1", 0));
		String test1="第二部你好第二部   ";
		System.out.println(test1.replaceAll("((第[一二三四五六七八九十百千万0-9]*[部集])|[ⅠⅡⅢⅣⅤ]*|\\d+)\\s*$",""));
		
		
	}

	public static int getn(int n)
	{
		if(n==1)
			return 1;
			
		return getn(n-1)+n;
		
	}
	public static String testtitle(String title, int i)
	{
		if(title==null ||title.equals(""))
			return "";
		String s = title;
		String par = "《(.*?)》";
		Pattern p1 = Pattern.compile(par);
		Matcher m1 = p1.matcher(s);
		while(m1.find())
		{				
			System.out.println(m1.group(1));
		
			String tmep=m1.group(1).replaceAll("&amp;", "&")
		     .replaceAll("&lt;", "<")
		     .replaceAll("&gt;", ">")
		     .replaceAll("&apos;", "\'")
		     .replaceAll("&quot;", "\"")
		     .replaceAll("&nbsp;", " ")
		     .replaceAll("&copy;", "@")
		     .replaceAll("&reg;", "?");
			return tmep;
		}				
		String[] t = s.split("[－-]|_|-|—");
		String reslut =t[0].replaceAll("&amp;", "&")
	     .replaceAll("&lt;", "<")
	     .replaceAll("&gt;", ">")
	     .replaceAll("&apos;", "\'")
	     .replaceAll("&quot;", "\"")
	     .replaceAll("&nbsp;", " ")
	     .replaceAll("&copy;", "@")
	     .replaceAll("&reg;", "?");
		String pattern = "(?:(?:^\\s*(?:0\\d*\\s+)?)|(?:^\\s*(?:[1-9]\\d*\\s+)?))(.*?)(?=((\\s?第[一二三四五六七八九十百千万兆亿0-9]+(?:集|部))|(0\\d*\\s*$)|(\\s+[1-9]\\d*\\s*$)))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(reslut);
		if(m.find())
		{
			return m.group(1);
		}
		return reslut;
	}
	
	
	  public static  String Utf8URLencode(String text) {
		    StringBuffer result = new StringBuffer();

		    for (int i = 0; i < text.length(); i++) {

		      char c = text.charAt(i);
		      if (c >= 0 && c <= 255) {
		        result.append(c);
		      }else {

		        byte[] b = new byte[0];
		        try {
		          b = Character.toString(c).getBytes("UTF-8");
		        }catch (Exception ex) {
		        }

		        for (int j = 0; j < b.length; j++) {
		          int k = b[j];
		          if (k < 0) k += 256;
		          result.append("%" + Integer.toHexString(k).toUpperCase());
		        }

		      }
		    }

		    return result.toString();
		  }
}
