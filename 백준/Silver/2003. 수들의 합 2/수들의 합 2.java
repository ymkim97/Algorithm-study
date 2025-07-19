import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int left = 0;
        int right = 0;
        int availCount = 0;
        
        sum += arr[right];
        
        while (right < N) {
        	if (sum <= M) {
        		if (sum == M) availCount += 1;
        		right += 1;
        		if (right == N) break;
        		sum += arr[right];
        	} else if (sum > M) {
        		sum -= arr[left];
        		left += 1;
        	}
        }
        
        System.out.println(availCount);
	}
}
