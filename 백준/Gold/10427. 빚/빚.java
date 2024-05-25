import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int[] debt = new int[N];
        	
        	for (int i = 0; i < N; i++) {
        		debt[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(debt);
        	
        	long answer = 0;
        	
        	for (int i = 2; i <= N; i++) {
        		answer += search(i, debt);
        	}
        	
        	System.out.println(answer);
        }
	}
	
	public static long search(int length, int[] debt) {
		long res = Long.MAX_VALUE;
		
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += debt[i];
		}
		
		int left = 0;
		int right = length - 1;
		
		while (right != debt.length) {
			long toPay = (debt[right] * length) - sum;
			res = Math.min(res, toPay);
			
			sum -= debt[left];
			left += 1;
			right += 1;
			
			if (right == debt.length) break;
			
			sum += debt[right];
		}
		
		return res;
	}
}