import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int testLimit = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test = 0; test < testLimit; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken()); // dependency cnt
        	int c = Integer.parseInt(st.nextToken()); // hacked pc
        	
        	List<Computer>[] map = new ArrayList[n + 1];
        	
        	for (int i = 0; i <= n; i++) {
        		map[i] = new ArrayList<>();
        	}
        	
        	for (int i = 0; i < d; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		int s = Integer.parseInt(st.nextToken());
        		
        		map[b].add(new Computer(a, s));
        	}
        	
        	int[] dist = new int[n + 1];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	
        	dijkstra(dist, c, map);
        	
        	int count = 0;
        	int time = 0;
        	
        	for (int i = 0; i <= n; i++) {
        		if (dist[i] != Integer.MAX_VALUE) {
        			count++;
        			time = Math.max(time, dist[i]);
        		}
        	}
        	
        	sb.append(count).append(' ').append(time).append("\n");
        }
        
        System.out.println(sb);
	}
	
	public static void dijkstra(int[] dist, int start, List<Computer>[] map) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 0: number, 1: time
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int num = now[0];
			int time = now[1];
			
			if (dist[num] < time) continue;
			
			for (Computer next : map[num]) {
				int tmp = time + next.time;
				
				if (tmp < dist[next.number]) {
					dist[next.number] = tmp;
					pq.offer(new int[] {next.number, tmp});
				}
			}
		}
	}
	
	static class Computer {
		int number;
		int time;
		
		public Computer(int number, int time) {
			this.number = number;
			this.time = time;
		}
	}
}
