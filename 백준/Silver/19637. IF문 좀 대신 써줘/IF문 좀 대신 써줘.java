import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] names = new String[N];
        int[] powers = new int[N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	names[i] = st.nextToken();
        	powers[i] = Integer.parseInt(st.nextToken());
        }
        	
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < M; t++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	int left = 0;
        	int right = N - 1;
        	
        	while (left <= right) {
        		int mid = (left + right) / 2;
        		
        		if (powers[mid] < num) {
        			left = mid + 1;
        		}
        		
        		else {
        			right = mid - 1;
        		}
        	}
        	
        	sb.append(names[left]).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}