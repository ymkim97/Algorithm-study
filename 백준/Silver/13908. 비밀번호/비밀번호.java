import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static int answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[10];
        
        if (m > 0) st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
        	visited[Integer.parseInt(st.nextToken())] = true;
        }
        
        backtrack(0, 0);
        
        System.out.println(answer);
	}
	
	public static void backtrack(int depth, int count) {
		if (depth == n) {
			if (count == m) answer += 1;
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) backtrack(depth + 1, count);
			else {
				visited[i] = false;
				backtrack(depth + 1, count + 1);
				visited[i] = true;
			}
		}
	}
}