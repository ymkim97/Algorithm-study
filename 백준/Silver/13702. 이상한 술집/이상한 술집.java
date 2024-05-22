import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] cups = new int[N];
        
        for (int i = 0; i < N; i++) {
        	cups[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cups);
        
        long left = 1;
        long right = cups[N - 1];
        long answer = 0;
        
        if (right == 0 || K == 0) {
        	System.out.println(answer);
        	return;
        }
        
        while (left <= right) {
        	long mid = (left + right) / 2;
        	int cnt = count(mid, cups);
        	
        	if (cnt >= K) {
        		answer = Math.max(answer, mid);
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        
        System.out.println(answer);
    }
    
    public static int count(long vol, int[] cups) {
    	int cnt = 0;
    	
    	for (int i = 0; i < cups.length; i++) {
    		cnt += cups[i] / vol;
    	}
    	
    	return cnt;
    }
}