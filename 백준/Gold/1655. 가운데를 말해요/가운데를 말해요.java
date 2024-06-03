import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	if (minQ.size() == maxQ.size()) maxQ.offer(n);
        	else minQ.offer(n);
        	
        	if (!minQ.isEmpty() && !maxQ.isEmpty()) {
        		if (minQ.peek() < maxQ.peek()) {
        			int tmp = minQ.poll();
        			minQ.offer(maxQ.poll());
        			maxQ.offer(tmp);
        		}
        	}
        	
        	sb.append(maxQ.peek()).append("\n");
        }
        
        System.out.println(sb);
	}
}