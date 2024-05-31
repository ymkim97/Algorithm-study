import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static List<Integer>[] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (map[a] == null) map[a] = new ArrayList<>();
        	if (map[b] == null) map[b] = new ArrayList<>();
        	
        	map[a].add(b);
        	map[b].add(a);
        }
        
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.offer(new int[] {1, 0});
        
        int[] countByDistance = new int[20001];
        int furtherestBarn = Integer.MAX_VALUE;
        int maxDist = 0;
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int num = now[0];
        	int cost = now[1];
        	
        	if (cost == maxDist) furtherestBarn = Math.min(furtherestBarn, num);
        	
        	if (cost > maxDist) {
        		maxDist = cost;
        		furtherestBarn = num;
        	}
        	
        	countByDistance[cost] += 1;
        	
        	for (int next : map[num]) {
        		if (visited[next]) continue;
        		
        		visited[next] = true;
        		q.offer(new int[] {next, cost + 1});
        	}
        }
        
        System.out.printf("%d %d %d\n", furtherestBarn, maxDist, countByDistance[maxDist]);
	}
}