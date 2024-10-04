import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<int[]>[] graph = new ArrayList[V + 1]; //0: to, 1: weight
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if (graph[u] == null) graph[u] = new ArrayList<>();
			if (graph[v] == null) graph[v] = new ArrayList<>();
			
			graph[u].add(new int[] {v, w});
		}
		
		int[] dist = new int[V + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {K, 0});
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int num = now[0];
			int d = now[1];
			
			if (dist[num] < d) continue;
			
			for (int[] next : graph[num]) {
				int tmp = d + next[1];
				
				if (tmp < dist[next[0]]) {
					dist[next[0]] = tmp;
					
					pq.offer(new int[] {next[0], tmp});
				}
			}
		}
		
		for (int i = 1; i < V + 1; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
}
