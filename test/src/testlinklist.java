import java.util.LinkedList;


public class testlinklist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> mlist =new LinkedList<String>();
		for(int i =0 ;i < 5; i++){
			mlist.add(""+i);
		}
		mlist.get(3);
		String s = mlist.removeLast();
		System.out.println(s);
	}

}
