import java.io.File;
import java.io.IOException;


public class filetest {

	
	public static int getmScale(int a,int b){
		
		
		
		
		return 0;
	}
	public static void main(String args[]){
		int a =3,b =5;
		int scale=0;
		int maxscale = Math.max(a, b);
		scale = maxscale%2==0?maxscale:maxscale+1;
		System.out.println(scale);
		scale = (a>b)?(a%2==0?a:a+1):(b%2==0?b:b+1);
		System.out.println(scale);
	}
	
}
