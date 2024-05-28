import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); // 0: FixedTime, 1: curTime
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	int t = Integer.parseInt(st.nextToken());
        	
        	pq.offer(new long[] {t, t});
        }
        
        long count = 0;
        long time = 0;
        
        while (count != M) {
        	long[] now = pq.poll();
        	
        	time = now[1];
        	count += 1;
        	
        	pq.offer(new long[] {now[0], now[0] + now[1]});
        }
        
        System.out.println(time);
	}
}