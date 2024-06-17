import java.util.*;
import java.io.*;

class Main {

	static Set<String> set = new HashSet<>();
	static String S;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        S = br.readLine();
        
        for (int i = 0; i < S.length(); i++) {
        	for (int j = i + 1; j <= S.length(); j++) {
        		set.add(S.substring(i, j));
        	}
        }
        
        System.out.println(set.size());
	}
}