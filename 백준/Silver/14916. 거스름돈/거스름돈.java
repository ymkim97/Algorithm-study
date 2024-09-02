import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
             
        int n = Integer.parseInt(br.readLine());
        
        int max = n / 5;
        
        boolean flag = false;
        while (max > 0) {
        	if ((n - (5 * max)) % 2 == 0) {
        		flag = true;
        		break;
        	}
        	max -= 1;
        }
        
        if (!flag) {
        	if ((n % 2 != 0)) {
        		System.out.println(-1);
            	return;
        	}
        	System.out.println(n / 2);
        	
        	return;
        }
        
        n -= (5 * max);
        
        System.out.println(max + (n / 2));
	}
}