import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int N = Integer.parseInt(br.readLine());
        
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        Stack<Integer> cards = new Stack<>();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	cards.add(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 1; i <= N; i++) {
        	int move = cards.pop();
        	
        	if (move == 1) {
        		ans.offerFirst(i);
        	} else if (move == 2) {
        		int tmp = ans.pollFirst();
        		ans.offerFirst(i);
        		ans.offerFirst(tmp);
        	} else if (move == 3) {
        		ans.offerLast(i);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sb.append(ans.pollFirst()).append(' ');
        }
        
        System.out.println(sb.toString());
	}
}