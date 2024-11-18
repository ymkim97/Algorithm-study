import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int c = Integer.parseInt(br.readLine());
        int test = 1;
        
        StringBuilder sb = new StringBuilder();
        
        while (test <= c) {
        	sb.append("Scenario ").append(test).append(":\n");
        	
        	int n = Integer.parseInt(br.readLine());
        	int k = Integer.parseInt(br.readLine());
        	
        	int[] parent = new int[n + 1];
        	
        	for (int i = 1; i <= n; i++) {
        		parent[i] = i;
        	}
        	
        	for (int i = 0; i < k; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		int aParent = find(a, parent);
        		int bParent = find(b, parent);
        		
        		if (aParent != bParent) union(a, b, parent);
        	}
        	
        	int m = Integer.parseInt(br.readLine());
    		
    		for (int j = 0; j < m; j++) {
    			st = new StringTokenizer(br.readLine());
    			
    			int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		if (find(x, parent) == find(y, parent)) sb.append(1);
        		else sb.append(0);
        		
        		sb.append("\n");
    		}
        	
        	test += 1;
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}
	
	public static int find(int n, int[] parent) {
		if (n == parent[n]) return n;
		
		return find(parent[n], parent);
	}
	
	public static void union(int a, int b, int[] parent) {
		a = find(a, parent);
		b = find(b, parent);
		
		parent[b] = a;
	}
}
