import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
           
        int N = Integer.parseInt(br.readLine());
        
        int left = 1;
        int right = 1;
        int sum = 1;
        
        int answer = 0;
        
        while (right <= N) {
              	
        	if (sum == N) {
        		answer += 1;
        		right += 1;
        		sum += right;
        	}
        	
        	else if (sum > N) {
        		sum -= left;
        		left += 1;
        	}
        	
        	else {
        		right += 1;
        		sum += right;
        	}
        }
        
        System.out.println(answer);
	}
}