import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.BitSet;


public class testhttpinputstream {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL("http://img0.178.com/wow/200912/53807051644/53807097589.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection connect = null;
		try {
			connect = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = null;
		
		try {
			in = connect.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.disconnect();
		System.out.println(in);
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("eerrr");
			e.printStackTrace();
			System.out.println("eerrr");
		}
		
	}

}
