import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        List<int[]>[] busList = new ArrayList[N + 1];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	if (busList[from] == null) busList[from] = new ArrayList<>();
        	
        	busList[from].add(new int[] {to, cost});
        }
        
        st = new StringTokenizer(br.readLine());
    	
    	int from = Integer.parseInt(st.nextToken());
    	int to = Integer.parseInt(st.nextToken());
    	
    	int[] costs = new int[N + 1];
    	Arrays.fill(costs, Integer.MAX_VALUE);
    	
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    	pq.offer(new int[] {from, 0});
    	costs[from] = 0;
    	
    	while (!pq.isEmpty()) {
    		int[] now = pq.poll();
    		int a = now[0];
    		int cost = now[1];
    		
    		if (costs[a] < cost || busList[a] == null) continue;
    		
    		for (int[] next : busList[a]) {
    			int nextCost = next[1] + cost;
    			
    			if (nextCost < costs[next[0]]) {
    				costs[next[0]] = nextCost;
    				pq.offer(new int[] {next[0], nextCost});
    			}
    		}
    	}
    	
    	System.out.println(costs[to]);
    }
}
