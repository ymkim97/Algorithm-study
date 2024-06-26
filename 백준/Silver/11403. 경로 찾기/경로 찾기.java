import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int k = 0; k < N; k++) {
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (map[i][k] + map[k][j] == 2) map[i][j] = 1;
        		}
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		System.out.printf("%d ", map[i][j]);
        	}
        	System.out.println();
        }
	}
}