import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		long sum = 0;
		Queue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			sum += n;
			pq.offer(n);
		}
		
		long answer = 0;
		
		for (int i = 0; i < N - 1; i++) {
			int cut = pq.poll();
			sum -= cut;
			
			answer += cut * sum;
		}
		
		System.out.println(answer);
	}
}
