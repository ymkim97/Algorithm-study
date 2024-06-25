import java.util.*;
import java.io.*;

class Main {
	
	static int answer = Integer.MIN_VALUE;
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        backtrack(0, 0, 0, 0);
        
        System.out.println(answer);
	}
	
	public static void backtrack(int depth, int sum, int x, int y) {
		if (depth == K) {
			answer = Math.max(sum, answer);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i < x) continue;
			
			for (int j = 0; j < M; j++) {
				if (i == x && j < y) continue;
				
				if (!visited[i][j]) {
					if (i - 1 >= 0 && i - 1 < N && visited[i - 1][j]) continue;
					if (i + 1 >= 0 && i + 1 < N && visited[i + 1][j]) continue;
					if (j - 1 >= 0 && j - 1 < M && visited[i][j - 1]) continue;
					if (j + 1 >= 0 && j + 1 < M && visited[i][j + 1]) continue;
					
					visited[i][j] = true;
					backtrack(depth + 1, sum + map[i][j], i, j + 1);
					visited[i][j] = false;
				}
			}
		}
	}
}