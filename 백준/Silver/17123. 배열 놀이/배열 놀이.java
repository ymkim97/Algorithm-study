import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
       StringBuilder sb = new StringBuilder();
           
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[][] map = new int[N][N];
        	int[] row = new int[N];
        	int[] col = new int[N];
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			int val = Integer.parseInt(st.nextToken());
        			map[i][j] = val;
        			row[i] += val;
        			col[j] += val;
        		}
        	}
        	
        	for (int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int r1 = Integer.parseInt(st.nextToken()) - 1;
        		int c1 = Integer.parseInt(st.nextToken()) - 1;
        		int r2 = Integer.parseInt(st.nextToken()) - 1;
        		int c2 = Integer.parseInt(st.nextToken()) - 1;
        		int v = Integer.parseInt(st.nextToken());
        		
        		for (int r = r1; r <= r2; r++) {
        			row[r] += (c2 - c1 + 1) * v;
        		}
        		
        		for (int c = c1; c <= c2; c++) {
        			col[c] += (r2 - r1 + 1) * v;
        		}
        		
        	}
        	
        	for (int i = 0; i < N; i++) {
        		sb.append(row[i]).append(" ");
        	}
        	sb.append("\n");
        	for (int i = 0; i < N; i++) {
        		sb.append(col[i]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}
}