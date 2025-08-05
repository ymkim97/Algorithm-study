import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        LinkedList<Integer> dq = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
        	dq.addLast(i);
        }
        
        int answer = 0;
        
        for (int i = 0; i < M; i++) { 
        	int idxToFind = dq.indexOf(numbers[i]);
        	int midIdx = 0;
        	
        	if (dq.size() % 2 == 0 ) {
        		midIdx = dq.size() / 2 - 1;
        	} else {
        		midIdx = dq.size() / 2;
        	}

        	
        	if (idxToFind <= midIdx) {
        		while (dq.peekFirst() != numbers[i]) {
        			dq.addLast(dq.removeFirst());
        			answer += 1;
        		}
        	} else {
        		while (dq.peekFirst() != numbers[i]) {
        			dq.addFirst(dq.removeLast());
        			answer += 1;
        		}
        	}
        	
        	dq.removeFirst();
        }
        
        System.out.println(answer);
    }
}
