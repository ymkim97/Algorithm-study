import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] task = new long[N];
        
        for (int i = 0; i < N; i++) {
        	task[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(task);
        
        long start = 0;
        long end = Long.MAX_VALUE;
        long answer = 1;
        
        while (start <= end) {
        	long mid = (start + end) / 2;
        	
        	long sum = 0;
        	
        	for (int i = 0; i < N; i++) {
        		sum += (mid / task[i]);
        		
        		if (sum >= M) break;
        	}
        	
        	if (sum >= M) {
        		answer = mid;
        		
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }
        
        System.out.println(answer);
	}
}
