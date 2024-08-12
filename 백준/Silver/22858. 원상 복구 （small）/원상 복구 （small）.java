import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
             
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] cards = new int[N + 1];
        int[] order = new int[N];
        int[] answer = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	cards[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	order[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int shuffle = 0; shuffle < K; shuffle++) {
        	for (int i = 0; i < order.length; i++) {
        		answer[order[i]] = cards[i + 1];
        	}
        	
        	cards = Arrays.copyOf(answer, answer.length);
        }
        
        for (int i = 1; i <= N; i++) {
        	System.out.printf("%d ", answer[i]);
        }
	}
}