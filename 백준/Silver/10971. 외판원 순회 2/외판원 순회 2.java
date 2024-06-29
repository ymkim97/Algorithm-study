import java.util.*;
import java.io.*;

class Main {

	static int answer = Integer.MAX_VALUE;
	static int N;
	static int start;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 1; j <= N; j++) {    		
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 1; i <= N; i++) {
        	visited = new boolean[N + 1];
        	start = i;
        	visited[i] = true;
        	dfs(i, 0, 0, map);
        }
        
        
        System.out.println(answer);
	}
	
	public static void dfs(int num, int depth, int sum, int[][] map) {
		if (depth == N - 1 && map[num][start] != 0) {
			answer = Math.min(answer, sum + map[num][start]);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[num][i] != 0) {
				visited[i] = true;
				dfs(i, depth + 1, sum + map[num][i], map);
				visited[i] = false;
			}
		}
	}
}