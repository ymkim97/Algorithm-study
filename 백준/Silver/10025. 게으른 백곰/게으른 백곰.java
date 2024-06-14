import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] map = new int[1_000_001];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int g = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	
        	map[x] = g;
        }
        
        int left = 0;
        int right = K * 2;
        int sum = 0;
        
        if (right >= 1_000_001) right = 1_000_000;
        
        for (int i = left; i <= right; i++) {
        	sum += map[i];
        }
        
        int answer = sum;
        
        while (right < map.length) {
        	answer = Math.max(sum, answer);
        	
        	right += 1;
        	if (right >= map.length) break;
        	
        	sum += map[right];
        	sum -= map[left];
        	
        	left += 1;
        }
        
        System.out.println(answer);
	}
}