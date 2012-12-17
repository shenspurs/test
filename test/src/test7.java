import java.math.BigInteger;

import javax.swing.JOptionPane;

public class test7 {
	/**
	 * @param args
	 */
	private static int n=0;
	private static int num[]={1,3,7,9,0};
	private static int size =3;
	public static void main(String[] args) {

		String s = "奥黛丽·塔图/吉约姆·卡内/劳伦特·斯托克";
		String tes[]=s.split("，|；|/|\\\\| ");
		
//		
//		int str[]={0,0,0,0};
//		
//		for(int i =0;i<3;i++)
//			for(int j=0;j<4;j++)
//			{
//				str[i]=num[j];
//
//				zuhe(str,i+1,3);
//
//				
//			}
//		System.out.println(n);
	}

	private static void zuhe(int[] str, int start, int end) {

		// TODO Auto-generated method stub
		for(int k =0 ;k<3;k++)
			System.out.print(str[k]);
		String s = ""+start+end;
		System.out.println("in zuhe)"+s);
		if(start==end)
			return;
		
		for(int i =start;i<end;i++)
		{

			for(int j=0;j<4;j++)
			{
				str[start]=num[j];
				
				zuhe(str,start+1,end);
				if(start+1==end)
				{
					for(int k =0 ;k<3;k++)
						System.out.print(str[k]);
					System.out.println("");
					n++;
				}
			
			}
			@SuppressWarnings("unused")
			int y=0;
		}
		for(int k =0 ;k<3;k++)
			System.out.print(str[k]);
		System.out.println("out zuhe)"+s);
	}

	
}