import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] days =  new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	days[i] = Integer.parseInt(st.nextToken());
        }
        
        long max = days[1];
        int cnt = 1;
        long sum = 0;
        
        int left = 1;
        int right = X;
        
        for (int i = 1; i <= X; i++) {
        	sum += days[i];
        }
        
        while (right <= N) {
        	if (sum >= max) {
        		if (sum == max) cnt += 1;
        		else {
        			cnt = 1;
        			max = sum;
        		}
        	}
        	
        	sum -= days[left];
        	left += 1;
        	
        	right += 1;
        	if (right == N + 1) break;
        	sum += days[right];
        }
        
        if (max == 0) System.out.println("SAD");
        else System.out.printf("%d\n%d", max, cnt);
	}
}