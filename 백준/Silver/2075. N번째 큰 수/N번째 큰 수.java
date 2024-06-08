import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		pq.offer(Integer.parseInt(st.nextToken()));
        	}
        }
        
        for (int i = 0; i < N - 1; i++) {
        	pq.poll();
        }
        
        System.out.println(pq.poll());
	}
}