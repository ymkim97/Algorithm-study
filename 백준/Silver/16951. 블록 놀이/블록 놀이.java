import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        int min = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
        	int[] tmp = new int[N];
        	
        	tmp[i] = nums[i];
        	
        	boolean flag = false;
        	
        	for (int j = i - 1; j >= 0; j--) {
        		tmp[j] = tmp[j + 1] - K;
        		
        		if (tmp[j] <= 0) {
        			flag = true;
        			break;
        		}
        	}
        	
        	if (flag) continue;
        	
        	for (int j = i + 1; j < N; j++) {
        		tmp[j] = tmp[j - 1] + K;
        	}
        	
        	int cnt = 0;
        	for (int j = 0; j < N; j++) {
        		if (tmp[j] != nums[j]) cnt += 1;
        	}
        	
        	min = Math.min(min, cnt);
        }
        
        System.out.println(min);
	}
}