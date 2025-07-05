import java.util.*;
import java.io.*;

class Main {
	
	static String answer = null;
	static int N;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        backtrack("");
	}
	
	private static void backtrack(String str) {
		if (str.length() == N) {
			if (answer != null) return;
			
			answer = str;
			System.out.println(answer);
			System.exit(0);
		}
		
		for (int i = 1; i <= 3; i++) {
			String tmp = str + Integer.toString(i);
			if (check(tmp)) {
				backtrack(tmp);
			}
		}
	}
	
	private static boolean check(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))) {
				return false;
			}
		}
		
		return true;
	}
}
