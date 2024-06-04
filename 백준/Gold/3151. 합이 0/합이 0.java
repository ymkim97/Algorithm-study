import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long answer = 0;
        
        for (int i = 0; i < N; i++) {
        	if (arr[i] > 0) break;
        	
        	int start = i + 1;
        	int end = N - 1;
        	
        	while (start < end) {
        		int cur = arr[i] + arr[start] + arr[end];
        		
        		if (cur == 0) {

            		int sameS = 1;
            		int sameE = 1;
        			
        			if (arr[start] == arr[end]) {
        				int n = end - start + 1;
        				answer += n * (n - 1) / 2;
        				break;
        			}
        			
        			while (arr[start] == arr[start + 1]) {
        				sameS += 1;
        				start += 1;
        			}
        			
        			while (arr[end] == arr[end - 1]) {
        				sameE += 1;
        				end -= 1;
        			}
        			
        			answer += sameS * sameE;
        			
        		}
        		
        		if (cur < 0) start += 1;
        		
        		else end -= 1;
        	}
        }
        
        System.out.println(answer);
	}
}