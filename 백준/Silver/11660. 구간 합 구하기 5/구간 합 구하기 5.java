import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N + 1][N + 1];
        int[][] sums = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 1; j <= N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
        		sums[i][j] = board[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int test = 0; test < M; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	sb.append(sums[x2][y2] - sums[x2][y1 - 1] - sums[x1 - 1][y2] + sums[x1 - 1][y1 - 1]).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}