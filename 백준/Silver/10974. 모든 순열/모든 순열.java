import java.util.*;
import java.io.*;

class Main {
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        visited = new boolean[N + 1];
        
        dfs(new ArrayList<>(), N);
	}
	
	public static void dfs(List<Integer> lst, int maxDepth) {
		if (lst.size() == maxDepth) {
			StringBuilder sb = new StringBuilder();
			
			for (int t : lst) {
				sb.append(t).append(" ");
			}
			
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = 1; i <= maxDepth; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lst.add(i);
				dfs(lst, maxDepth);
				visited[i] = false;
				lst.remove(lst.size() - 1);
			}
		}
	}
}