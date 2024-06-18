import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        Stack<Long> stk = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        long max = 0;
        long ans = 0;
        
        for (int i = 0; i < N; i++) {
        	long num = Integer.parseInt(br.readLine());
        	max = Math.max(max, num);
        	
        	if (stk.isEmpty()) stk.push(num);
        	else {
        		if (stk.peek() < num) {
        			ans += num - stk.pop();
        			stk.push(num);
        		}
        		
        		else if (stk.peek() > num) {
        			stk.pop();
        			stk.push(num);
        		}
        	}
        }
        
        while (!stk.isEmpty()) {
        	long num = stk.pop();
        	ans += max - num;
        }
        
        System.out.println(ans);
	}
}