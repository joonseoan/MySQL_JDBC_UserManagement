package jdbcDatabase;

public class RacingResult {
	
	
	public static String result[] = new String[ 1000 ];
	public static int num = 0;
	public static boolean gameOver = false;
	public static int winner = -1;		// -1 무승부,   0 내가 이김,     1 컴 이김
	public static int myNum = 0;
	
	public static void reset() {
		
		result = new String[ 1000 ];
		num = 0;		// UseMyF1Car 클래스가 바꾸는 변수
		myNum = 0;		// Main 클래스가 바꾸는 변수
		winner = -1;
		gameOver = false;
	}
	
	public static void add( String line ) {
		
		result[ num ] = new String(line);
System.out.println( "NUM:" + num + " ==> " + result[num]);
		num++;
		
	}

}
