import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        
        int[] prices = new int[n];
        
        for (int i = 0; i < n; i++) {
        	int price = Integer.parseInt(br.readLine());
        	
        	prices[i] = price;
        }
        
        long coin = 0;
        
        for (int i = 0; i < n - 1; i++) {
        	if (coin == 0 && prices[i] < prices[i + 1]) {
        		coin = W / prices[i];
        		W -= coin * prices[i];
        	}
        	
        	if (prices[i] > prices[i + 1]) {
        		W += coin * prices[i];
        		coin = 0;
        	}
        }
        
        W += coin * prices[n - 1];
        
        System.out.println(W);
	}
}