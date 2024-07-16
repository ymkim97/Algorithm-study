import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        
        int[] snow = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	snow[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(snow);
        
        for (int i = 0; i < N; i++) {
        	for (int j = i + 1; j < N; j++) {
        		int elsa = snow[i] + snow[j];
        		
        		int start = 0;
        		int end = N - 1;
        		
        		while (start < end) {
        			if (start == i || start == j) {
        				start += 1;
        				continue;
        			}
        			
        			if (end == i || end == j) {
        				end -= 1;
        				continue;
        			}
        			
        			int anna = snow[start] + snow[end];
        			answer = Math.min(answer, Math.abs(elsa - anna));
        			
        			if (anna > elsa) end -= 1;
        			else if (anna < elsa) start += 1;
        			else {
        				System.out.println(0);
        				return;
        			}
        		}
        	}
        }
        
        System.out.println(answer);
	}
}