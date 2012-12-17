public class TestStringConnection {
    
    //连接时间的设定
    private final static int n = 20000;
    
    public static void main(String[] args){
       TestStringConnection test = new TestStringConnection ();
       test.testStringTime(n);
       test.testStringBufferTime(n);
       test.testStringBuilderTime(n);
       
       
//       //连接10次
//       test.testStringTime(10);
//       test.testStringBufferTime(10);
//       test.testStringBuilderTime(10);
//       
//       //连接100
//       
//       test.testStringTime(100);
//       test.testStringBufferTime(100);
//       test.testStringBuilderTime(100);
//       
//       
//       
//       //连接1000
//       
//       test.testStringTime(1000);
//       test.testStringBufferTime(1000);
//       test.testStringBuilderTime(1000);
//       
//       
//      //连接5000
//       
//       test.testStringTime(5000);
//       test.testStringBufferTime(5000);
//       test.testStringBuilderTime(5000);
//       
//       
// //连接10000
//       
//       test.testStringTime(10000);
//       test.testStringBufferTime(10000);
//       test.testStringBuilderTime(10000);
//       
// //连接20000
//       
//       test.testStringTime(20000);
//       test.testStringBufferTime(20000);
//       test.testStringBuilderTime(20000);
    }
    
    /**
     *测试String连接字符串的时间
     */
    public void testStringTime(int n){
       long start = System.currentTimeMillis();
       String a = "";
       for(int k=0;k<n;k++ ){
           a += "_" + k;
       }
       long end = System.currentTimeMillis();
       long time = end - start;
       System.out.println("//////////////////////连接"+n+"次" );
       System.out.println("String time "+n +":"+ time);
       //System.out.println("String str:" + str);
    }
    
    /**
     *测试StringBuffer连接字符串的时间
     */
    public void testStringBufferTime(int n){
       long start = System.currentTimeMillis();
       StringBuffer b = new StringBuffer() ;
       for(int k=0;k<n;k++ ){
           b.append( "_" + k );
       }
       long end = System.currentTimeMillis();
       long time = end - start;
       System.out.println("StringBuffer time "+n +":"+ time);
       //System.out.println("StringBuffer str:" + str);
    }
    
    /**
     *测试StringBuilder连接字符串的时间
     */
    public void testStringBuilderTime(int n){
       long start = System.currentTimeMillis();
       StringBuilder c = new StringBuilder() ;
       for(int k=0;k<n;k++ ){
           c.append( "_" + k );
       }
       long end = System.currentTimeMillis();
       long time = end - start;
       System.out.println("StringBuilder time " +n +":"+ time);
       
       System.out.println("//////////////////////");

       //System.out.println("StringBuffer str:" + str);
    }

}