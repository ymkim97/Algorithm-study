import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N + 1][N + 1];
        int answer = Integer.MIN_VALUE;
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 1; j <= N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		answer = Math.max(answer, map[i][j]);
        	}
        }
        
        int[][] prefixSum = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
        	if (i == 1) {
        		for (int j = 1; j <= N; j++) {
        			prefixSum[i][j] = map[i][j] + prefixSum[i][j - 1];
        		}
        	} 
        	
        	else {
	    		for (int j = 1; j <= N; j++) {
	    			if (j == 1) prefixSum[i][j] = map[i][j] + prefixSum[i - 1][j];
	    			
	    			else {
	    				prefixSum[i][j] = map[i][j] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
	    			}
	    		}
        	}
        }
        
        for (int i = 1; i <= N; i++) {	 	
        	for (int j = 1; j <= N; j++) {
        		if (i == 1) {
            		answer = Math.max(answer, prefixSum[i][j] - prefixSum[i][j - 1]);
            	}
        		
        		else if (j == 1) {
            		answer = Math.max(answer, prefixSum[i][j] - prefixSum[i - 1][j]);
            	} 
            	
            	else {
            		int k = 1;
            		
            		while (i - k != 0 && j - k != 0) {
            			answer = Math.max(answer, prefixSum[i][j] - prefixSum[i - k - 1][j] - prefixSum[i][j - k - 1] + prefixSum[i - k - 1][j - k - 1]);
            			
            			k += 1;
            		}
            	}
        	}
        }
        
        System.out.println(answer);
    }
}
