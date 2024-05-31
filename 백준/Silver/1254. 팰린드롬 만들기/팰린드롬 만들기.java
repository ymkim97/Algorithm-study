import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String S = br.readLine();
        
        for (int i = 0; i < S.length(); i++) {
        	if (isPalindrome(S.substring(i))) {
        		System.out.println(S.length() + i);
        		return;
        	}
        }
	}
	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
}