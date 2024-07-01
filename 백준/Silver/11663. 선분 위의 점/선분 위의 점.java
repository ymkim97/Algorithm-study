import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] dots = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	dots[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(dots);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	int left = 0;
        	int right = N - 1;
        	
        	while (left <= right) {
        		int mid = (left + right) / 2;
        		
        		if (dots[mid] > b) right = mid - 1;
        		else left = mid + 1;
        	}
        		
        	int rightIdx = right + 1;
        	
        	left = 0;
        	right = N - 1;
        	
        	while (left <= right) {
        		int mid = (left + right) / 2;
        		
        		if (dots[mid] < a) left = mid + 1;
        		else right = mid - 1;
        	}
        	
        	int leftIdx = left;
        	
        	sb.append(rightIdx - leftIdx).append("\n");
        }
        
        System.out.println(sb);
	}
}