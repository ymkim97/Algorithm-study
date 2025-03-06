import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder answer = new StringBuilder();
        
        for (int test = 0; test < T; test++) {
        	char[] message = br.readLine().toCharArray();
        	
        	int n = (int) Math.sqrt(message.length);
        	
        	char[][] chars = new char[n][n];
        	
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			chars[i][j] = message[i * n + j];
        		}
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	
        	for (int i = n - 1; i >= 0; i--) {
        		for (int j = 0; j < n; j++) {
        			sb.append(chars[j][i]);
        		}
        	}
        	
        	answer.append(sb).append("\n");
        }
        
        System.out.println(answer);
	}
}
