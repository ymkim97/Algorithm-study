import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int test = 1; test <= T; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int D = Integer.parseInt(st.nextToken());
        	long C = Long.parseLong(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int dCount = 0;
        	
        	char[] animals = br.readLine().toCharArray();
        	
        	for (char a : animals) {
        		if (a == 'D') dCount += 1;
        	}
        	
        	for (int i = 0; i < N; i++) {
        		if (animals[i] == 'C') {
        			if (C > 0) C -= 1;
        			else break;
        		} else {
        			if (D > 0) {
        				dCount -= 1;
        				D -= 1;
        				C += M;
        			} else break;
        		}
        	}
        	
        	sb.append("Case #").append(test).append(": ");
        	
        	if (dCount != 0) sb.append("NO").append("\n");
        	else sb.append("YES").append("\n");
        }
        
        System.out.println(sb);
	}
}