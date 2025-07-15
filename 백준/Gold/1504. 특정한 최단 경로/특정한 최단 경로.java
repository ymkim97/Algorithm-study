import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        List<int[]>[] graph = new ArrayList[N + 1]; // idx 0: node, 1: weight
        
        for (int i = 0; i <= N; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	graph[a].add(new int[] {b, c});
        	graph[b].add(new int[] {a, c});
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        long[] fromOne = dijkstra(1, graph);
        long[] fromV1 = dijkstra(v1, graph);
        long[] fromV2 = dijkstra(v2, graph);
        
        if (fromOne[v1] == Integer.MAX_VALUE || fromOne[v2] == Integer.MAX_VALUE || fromOne[N] == Integer.MAX_VALUE) {
        	System.out.println(-1);
        	return;
        }
        
        long a = fromOne[v1] + fromV1[v2] + fromV2[N];
        long b = fromOne[v2] + fromV2[v1] + fromV1[N];
        
        System.out.println(Math.min(a, b));
	}
	
	private static long[] dijkstra(int from, List<int[]>[] graph) {
		long[] distance = new long[graph.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[from] = 0;
		
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // idx 0: node, 1: weight
		pq.offer(new int[] {from, 0});
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int node = now[0];
			int w = now[1];
			
			if (distance[now[0]] < w) continue;
			
			for (int next[] : graph[node]) {
				int nextWeight = w + next[1];
				
				if (nextWeight < distance[next[0]]) {
					distance[next[0]] = nextWeight;
					pq.offer(new int[] {next[0], nextWeight});
				}
			}
		}
		
		
		return distance;
	}
}
