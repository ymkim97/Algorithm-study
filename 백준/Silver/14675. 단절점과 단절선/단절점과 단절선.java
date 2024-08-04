import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        int[] nodeCnt = new int[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	nodeCnt[a]++;
        	nodeCnt[b]++;
        }
        
        int q = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < q; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int t = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	if (t == 1) {
        		if (nodeCnt[k] == 1) sb.append("no").append("\n");
        		else sb.append("yes").append("\n");
        	}
        	
        	else sb.append("yes").append("\n");
        }
        
        System.out.println(sb.toString());
	}
}