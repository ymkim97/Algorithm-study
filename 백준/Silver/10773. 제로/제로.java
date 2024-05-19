import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        
        Stack<Integer> q = new Stack<>();
        
        for (int i = 0; i < K; i++) {
        	int t = Integer.parseInt(br.readLine());
        	
        	if (t == 0) {
        		q.pop();
        	} else {
        		q.add(t);
        	}
        }
        
        int answer = 0;
        
        while (!q.isEmpty()) {
        	answer += q.pop();
        }
        
        System.out.println(answer);
    }
}