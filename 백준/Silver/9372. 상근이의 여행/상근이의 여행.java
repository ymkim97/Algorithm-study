import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int n = Integer.parseInt(st.nextToken());
        	int planes = Integer.parseInt(st.nextToken());
        	
        	for (int i = 0; i < planes; i++) {
        		br.readLine();
        	}
        	
        	System.out.println(n - 1);
        }
	}
}