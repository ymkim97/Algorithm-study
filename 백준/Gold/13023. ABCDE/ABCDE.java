import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static List<Integer>[] friend;
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        friend = new ArrayList[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	friend[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	friend[a].add(b);
        	friend[b].add(a);
        }
        
        for (int i = 0; i < N; i++) {
        	visited[i] = true;
        	dfs(1, i);
        	visited[i] = false;
        }
        
        System.out.println(answer);
	}
	
	public static void dfs(int depth, int idx) {
		if (depth == 5 || answer == 1) {
			answer = 1;
			return;
		}
		
		for (int next : friend[idx]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(depth + 1, next);
				visited[next] = false;
			}
		}
	}
}