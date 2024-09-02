import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // 0: price, 1: day
        	if (a[0] == b[0]) return b[1] - b[1];
        			
        	return b[0] - a[0];
        });
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int p = Integer.parseInt((st.nextToken()));
        	int d = Integer.parseInt((st.nextToken()));
        	
        	pq.offer(new int[] {p, d});
        }
        
        boolean check[] = new boolean[10001];
        
        int answer = 0;
        
        while (!pq.isEmpty()) {
        	int[] now = pq.poll();
        	
        	int p = now[0];
        	int d = now[1];
        	
        	for (int i = d; i > 0; i--) {
        		if (!check[i]) {
        			check[i] = true;
        			answer += p;
        			break;
        		}
        	}
        }
        
        System.out.println(answer);
	}
}