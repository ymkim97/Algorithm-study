import java.util.*;
import java.io.*;

class Main {
	
	static int N, max, maxNode;
	static List<Integer>[] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        N = Integer.parseInt(br.readLine());
        
        map = new ArrayList[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (map[a] == null) map[a] = new ArrayList<>();
        	if (map[b] == null) map[b] = new ArrayList<>();
        	
        	map[a].add(b);
        	map[b].add(a);
        }
        
        max = -1;
        visited = new boolean[N + 1];
        dfs(1, 0);
        
        max = -1;
        visited = new boolean[N + 1];
        dfs(maxNode, 0);
        
        System.out.println((max + 1) / 2);        
	}
	
	public static void dfs(int num, int depth) {
		if (max < depth) {
			max = depth;
			maxNode = num;
		}
		
		visited[num] = true;
		
		for (int next : map[num]) {
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
	}
}