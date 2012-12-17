import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class testsplit {
	class A
	{
	 B b;
	}
	class B{
		
	}

	public static void main(String[] args)  {
		
		
		String sf ="暮光之城4:    减肥哦解放";
		System.out.println(sf.replaceAll(":.*$", ""));
		testsplit test =new testsplit();
		testsplit.getFilmName mtitlename = test.new getFilmName("向着炮火前进 38—在线播放—《向着炮火前进 TV版》—电视剧—优酷网，视频高清在线观看");
		System.out.println(mtitlename.getTitleWithIndex());
		System.out.println(mtitlename.getTitleForFilmrelated());
		String s[]={"1"};
//		String test = "1123456789";
//
//		String s3= "打开电影网";
//		String pattern1 ="^(?:打开)?(电影网|\\S+?)(网站?)?$";
//		Pattern p1 = Pattern.compile(pattern1);
//		Matcher m1 = p1.matcher(s3);
//		if(m1.find())
//		{
//			System.out.println(m1.group(1));
//		}
//		
//		
//		
//		if (test.contains("."))
//			test = test
//					.replaceAll(
//							"((?<=\\d)(?=(?:\\d\\d\\d)+(\\.))|((?<=(\\.(?:\\d\\d\\d)+))(?=\\d)))",
//							",");
//		else
//			test = test.replaceAll("(?<=\\d)(?=(?:\\d\\d\\d)+$)", ",");
//		System.out.println(test);
//
//		System.out
//				.println(getFilmName(" 功夫熊猫 第二部 "));
//		String xyposition ="http://10llfesejioji?x=128&y=108";
//		String pattern = "^(.*?)\\?x=(\\d{1,3})&y=(\\d{1,3})$";
//		Pattern p = Pattern.compile(pattern);
//		Matcher m = p.matcher(xyposition);
//		if(m.find())
//		{
//			System.out.println("x="+m.group(2)+"y="+m.group(3)+"  "+m.group(1));
//		}
//		long t1 =  System.currentTimeMillis();
//		  URL url = new URL("http://v.youku.com/v_show/id_XNDY1MDUwNjI0.html?f=18436313");  
//		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
//		 
//		  conn.setRequestMethod("GET");  
//		 
////		  conn.setRequestProperty("User-Agent", "Mozilla/4.0");
//		  conn.setRequestProperty("Range", "Bytes=0-1024");
//		  conn.setConnectTimeout(5 * 1000); 
//		  InputStream inStream = conn.getInputStream();// 通过输入流获取html数据  
//		  long t2 =  System.currentTimeMillis();
//		  System.out.println(t2-t1);
//		 
//	        byte[] data = null;
//			try {
//				data = readInputStream(inStream);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}// 得到html的二进制数据   
//	        String html = new String(data);  
//	        long t3 =  System.currentTimeMillis();
//	        System.out.println(t3-t2);
//	        System.out.println(html);
//	     
//
//		
//		
//		digui("< div > nihao <div > <img src='http://10.3.34.245/index.php'></img></div>< / div > ","<\\s*div\\s*>","<\\s*/\\s*div\\s*>");
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception{  
        //此类实现了一个输出流，其中的数据被写入一个 byte 数组   
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        // 字节数组   
        byte[] buffer = new byte[1024];  
        int len = 0;  
        //从输入流中读取一定数量的字节，并将其存储在缓冲区数组buffer 中   
        while ((len = inStream.read(buffer)) != -1) {  
            // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流   
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        //toByteArray()创建一个新分配的 byte 数组。   
        return outStream.toByteArray();  
    }  
  
	public static String getFilmName(String title) {
		String s1 ="あいえうお　かきくけこ　さしすせそ　たちつてと　なにぬねの　はひぬねほ　まみぬめも　やいゆえよ　らりるれろ　わいうえを　ん　";
		String s2 ="アイウエオ     カキクケコ　サィスセソ　タチシテト　ナニヌネノ　ハヒフヘホ　マミムメモ　ヤイユエヨ　ラリルレロ　ワイウエヲ　ン";
		String s3 ="ぱぴぷぺぽ　がきぐげご　ざじずぜぞ　だぢづでど　ばびぶべぼ";
		String s4 ="パピプペポ　ガギグゲゴ　ザジズゼゾ　ダヂヅデド　バビブベボ";
		
		
		
		
		
		
		String s = title;
		String par = "《(《?(.*?)》?)》";
		
		Pattern p1 = Pattern.compile(par);
		Matcher m1 = p1.matcher(s);
		while (m1.find()) {
			System.out.println(m1.group(1));
			return m1.group(1);
			
		}
		String[] t = s.split("[－-]|_|-");
		System.out.println(t[0]);
		String pattern = "(?:(?:^\\s*(?:0\\d*\\s+)?)|(?:^\\s*(?:[1-9]\\d*\\s+)?))(.*?)(?=((\\s?第[一二三四五六七八九十百千万兆亿0-9]+[集部])|(0\\d*\\s*$)|([1-9]\\d*\\s*$)))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(t[0]);
		if (m.find()) {
			System.out.println(m.group(1) + "  111");
			return m.group(1);
		} else
			System.out.println("null");

		return t[0];

	}

	public static List<String> digui(String source,String prePattern, String lPattern) {

		String firstPattern = prePattern.replaceAll("\\\\s\\*", " ");
		String lastPattern = lPattern.replaceAll("\\\\s\\*", " ");
		boolean isStringAdd = false;
		List<String> target = new ArrayList<String>();
		String temp = "";
		Stack<String> stack = new Stack<String>();
		String pattern = "(.*?)("+prePattern+"|"+lPattern+")";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		while (m.find()) {
			if (isStringAdd)
				temp += m.group(1);
			if (m.group(2).matches(prePattern)) {
				stack.push(firstPattern);
				if (!isStringAdd)
					isStringAdd = true;
				else
					temp += firstPattern;
			} else if (m.group(2).matches(lPattern)) {
				stack.pop();
				if (!stack.empty()) {
					temp += lastPattern;
				} else {
					target.add(temp);
					temp = "";
					isStringAdd = false;
				}
			}


		}
		for (int i = 0; i < target.size(); i++)
			System.out.println(target.get(i));
			return target;

	}

	public static class Stack<T> {

		private LinkedList<T> storage = new LinkedList<T>();

		public void push(T v) {
			storage.addFirst(v);
		}

		public T pop() {
			return storage.removeFirst();
		}

		public T peek() {
			return storage.getFirst();
		}

		public boolean empty() {
			return storage.isEmpty();
		}

		public String toString() {
			return storage.toString();
		}
	}
	 public class getFilmName{
	    	private String 	title="";
	    	private String 	firstTitle="";
	    	private String 	midTitle="";
	    	private String 	midSplitWithoutNum="";
			public  getFilmName(String title)
			{			
			
				if(title==null ||title.equals(""))
					return;
				this.title=title;
				String[] t = title.split("[－-]|_|-|—");
				String result =t[0].replaceAll("&amp;", "&")
			     .replaceAll("&lt;", "<")
			     .replaceAll("&gt;", ">")
			     .replaceAll("&apos;", "\'")
			     .replaceAll("&quot;", "\"")
			     .replaceAll("&nbsp;", " ")
			     .replaceAll("&copy;", "@")
			     .replaceAll("&reg;", "?");
				firstTitle=result;
				String par = "《(.*?)》";
				Pattern p1 = Pattern.compile(par);
				Matcher m1 = p1.matcher(title);
				while(m1.find())
				{				
					System.out.println(m1.group(1));
				
					String s=m1.group(1).replaceAll("&amp;", "&")
				     .replaceAll("&lt;", "<")
				     .replaceAll("&gt;", ">")
				     .replaceAll("&apos;", "\'")
				     .replaceAll("&quot;", "\"")
				     .replaceAll("&nbsp;", " ")
				     .replaceAll("&copy;", "@")
				     .replaceAll("&reg;", "?");
				     midTitle=s;
				     midSplitWithoutNum =s.replaceAll("(第[一二三四五六七八九十千0-9]+[部集季话]|[ⅠⅡⅢⅣⅤ])\\s*$", "");
				     midSplitWithoutNum =midSplitWithoutNum.trim();
				}
				
			}
			
			public String getTitleWithIndex()
			
			{
				String result="";
				if(midTitle.length()>0 &&midTitle.matches("^.*(第[一二三四五六七八九十千0-9][部集季话])$"))
					result = midTitle;
				else
					result =firstTitle;
				return result;
				
			}
			
			public String getTitleForFilmrelated()
			{
				String result="";
				String pattern = "(?:(?:^\\s*(?:0\\d*\\s+)?)|(?:^\\s*(?:[1-9]\\d*\\s+)?))(.*?)(?=((\\s?第[一二三四五六七八九十百千万兆亿0-9]+(?:集|部|季|话).*$)|(0\\d*\\s*$)|(\\s+[1-9]\\d*\\s*$)))";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(firstTitle);
				if(m.find())
				{
					result= m.group(1);
				}
				
				
				if((!midSplitWithoutNum.isEmpty()&&!result.isEmpty()&&midSplitWithoutNum.length()<result.length())|result.isEmpty())
					result =midSplitWithoutNum;
				return result;
			}
			public String getMidSplitWithoutNum()
			{
				return midSplitWithoutNum;
			}
			public String getTitle()
			{
				return title;
			}
	    }
}
