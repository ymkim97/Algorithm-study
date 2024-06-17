import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] levels = new int[N];
        
        for (int i = 0; i < N; i++) {
        	levels[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(levels);
        
        long left = levels[0];
        long right = levels[N - 1] + K;
        long answer = left;
        
        while (left <= right) {
        	long mid = (left + right) / 2;
        	long tmp = 0;
        	
        	for (int i = 0; i < N; i++) {
        		if (levels[i] < mid) tmp += mid - levels[i];
        		else break;
        	}
        	
        	if (tmp <= K) {
        		answer = mid;
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        
        System.out.println(answer);
	}
}