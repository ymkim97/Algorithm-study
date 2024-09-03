import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int answer = 0;
        int evenCnt = 0;
        int cutCnt = 0;
        
        for (int right = 0; right < N; right++) {
        	if (numbers[right] % 2 == 0) {
        		evenCnt += 1;
        	} else {
        		 cutCnt += 1;
        		 
        		 if (cutCnt > K) {

        			if (numbers[left] % 2 != 0) {
        				left += 1;
            			cutCnt -= 1;
        			}
        			else {
        				while (numbers[left] % 2 == 0) {
            				left += 1;
            				evenCnt -= 1;
            			}
        				
        				left += 1;
        				cutCnt -= 1;
        			}
        		}
        	}
        	
        	answer = Math.max(answer, evenCnt);
        }
        
        System.out.println(answer);
	}
}