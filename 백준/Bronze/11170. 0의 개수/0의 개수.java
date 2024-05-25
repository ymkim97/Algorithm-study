import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int count = 0;
        	
        	for (int i = N; i <= M; i++) {
        		if (i == 0) {
        			count += 1;
        			continue;
        		}
        		
        		int num = i;
        		
        		while (num != 0) {
        			if (num % 10 == 0) count += 1;        			
        			
        			num /= 10;
        		}
        	}
        	
        	System.out.println(count);
        }
	}
}