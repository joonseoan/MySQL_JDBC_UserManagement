package jdbcDatabase;

public class RacingResult {
	
	
	public static String result[] = new String[ 1000 ];
	public static int num = 0;
	public static boolean gameOver = false;
	public static int winner = -1;		// -1 ���º�,   0 ���� �̱�,     1 �� �̱�
	public static int myNum = 0;
	
	public static void reset() {
		
		result = new String[ 1000 ];
		num = 0;		// UseMyF1Car Ŭ������ �ٲٴ� ����
		myNum = 0;		// Main Ŭ������ �ٲٴ� ����
		winner = -1;
		gameOver = false;
	}
	
	public static void add( String line ) {
		
		result[ num ] = new String(line);
System.out.println( "NUM:" + num + " ==> " + result[num]);
		num++;
		
	}

}
