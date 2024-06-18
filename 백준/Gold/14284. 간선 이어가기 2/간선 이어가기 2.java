import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<int[]>[] map = new ArrayList[n + 1];
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if (map[a] == null) map[a] = new ArrayList<>();
        	if (map[b] == null) map[b] = new ArrayList<>();
        	
        	map[a].add(new int[] {b, c});
        	map[b].add(new int[] {a, c});
        }
        
        st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 0: node, 1: weight
        pq.offer(new int[] {s, 0});
        
        while (!pq.isEmpty()) {
        	int[] now = pq.poll();
        	int node = now[0];
        	int cost = now[1];
        	
        	if (cost < dist[node]) continue;
        	
        	for (int[] next : map[node]) {
        		int tmp = cost + next[1];
        		
        		if(tmp < dist[next[0]]) {
        			dist[next[0]] = tmp;
        			pq.offer(new int[] {next[0], tmp});
        		}
        	}
        }
        
        System.out.println(dist[t]);
	}
}