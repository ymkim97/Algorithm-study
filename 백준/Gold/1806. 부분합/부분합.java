import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 100001;
        int left = 0;
        int right = 0;
        int sum = nums[0];
        
        while (right < N) {
        	
        	if (sum < S) {
        		right += 1;
        		if (right == N) break;
        		sum += nums[right];
        	}
        	
        	else if (sum >= S) {
        		answer = Math.min(answer, right - left + 1);
        		sum -= nums[left];
        		left += 1;
        	}
        }
        
        System.out.println(answer == 100001 ? 0 : answer);
    }
}