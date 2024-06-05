import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        int[] dist = new int[N];
        
        int sum = 0;
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
        	dist[i] = Integer.parseInt(br.readLine());
        	sum += dist[i];
        }
        
        int pointerA = 0;
        int pointerB = 1;
        
        int right = dist[pointerA];
        int left = sum - right;
        
        while (pointerA < N) {
        	ans = Math.max(ans, Math.min(right, left));
        	
        	if (right < left) {
        		right += dist[pointerB];
        		left -= dist[pointerB];
        		pointerB += 1;
        		pointerB %= N;
        	}
        	
        	else {
        		right -= dist[pointerA];
        		left += dist[pointerA];
        		pointerA += 1;
        	}
        }
        
        System.out.println(ans);
	}
}