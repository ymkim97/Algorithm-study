import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int[] sums = new int[N];
        sums[0] = arr[0];
        
        for (int i = 1; i < N; i++) {
        	sums[i] = sums[i - 1] + arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int question = 0; question < Q; question++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	
        	if (a == 0) {
        		sb.append(sums[b]).append("\n");
        	}
        	
        	else {
        		sb.append(sums[b] - sums[a - 1]).append("\n");
        	}
        }
        
        System.out.println(sb);
	}
}