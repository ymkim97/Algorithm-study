import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
        	q.offer(i);
        }
        
        while (q.size() != 1) {
        	q.poll();
        	q.offer(q.poll());
        }
        
        System.out.println(q.poll());
	}
}