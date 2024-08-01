import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String s = br.readLine();
        
        int q = Integer.parseInt(br.readLine());
        
        int[][] prefixSum = new int[26][s.length() + 1];
        
        for (int i = 0; i < s.length(); i++) {
        	prefixSum[s.charAt(i) - 'a'][i + 1] = prefixSum[s.charAt(i) - 'a'][i] + 1;
        	
        	for (int j = 0; j < 26; j++) {
        		if (j == s.charAt(i) - 'a') continue;
        		
        		prefixSum[j][i + 1] = prefixSum[j][i];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < q; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	char alphabet = st.nextToken().charAt(0);
        	int from = Integer.parseInt(st.nextToken()) + 1;
        	int to = Integer.parseInt(st.nextToken()) + 1;
        	
        	sb.append(prefixSum[alphabet - 'a'][to] - prefixSum[alphabet - 'a'][from - 1]).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}