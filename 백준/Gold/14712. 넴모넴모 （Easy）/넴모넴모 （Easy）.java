import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static boolean[][] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N][M];
        
        dfs(0, 0);
        
        System.out.println(answer);
	}
	
	public static void dfs(int depth, int start) {
		
		answer += check(depth) ? 1 : 0;
		
		if (depth == N * M) return;
		
		for (int i = start; i < N * M; i++) {
			int r = i / M;
			int c = i % M;
			
			if (visited[r][c]) continue;
			
			visited[r][c] = true;
			dfs(depth + 1, i + 1);
			visited[r][c] = false;
		}
	}
	
	public static boolean check(int depth) {
		if (depth < 4) return true;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]) return false;
			}
		}
		
		return true;
	}
}