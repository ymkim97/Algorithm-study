import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	String command = br.readLine();
        	int n = Integer.parseInt(br.readLine());
        	String arr = br.readLine();
        	
        	arr = arr.substring(1, arr.length() - 1);
        	st = new StringTokenizer(arr, ",");
        	
        	Deque<Integer> dq = new ArrayDeque<>();
        	
        	while (st.hasMoreTokens()) {
        		dq.addLast(Integer.parseInt(st.nextToken()));
        	}
        	
        	int pointer = 0; // 0: left, 1: right
        	boolean isError = false;
        	
        	for (char c : command.toCharArray()) {
        		if (c == 'R') pointer = (pointer + 1) % 2;
        		
        		else if (c == 'D') {
        			if (dq.isEmpty()) {
        				isError = true;
        				break;
        			}
        			
        			else {
        				if (pointer == 0) dq.removeFirst();
        				else dq.removeLast();
        			}
        		}
        	}
        	
        	if (isError) System.out.println("error");
        	else {
//        		System.out.printf("[");
        		StringBuilder sb = new StringBuilder();
        		sb.append("[");
        		
        		if (pointer == 0) {
        			while (!dq.isEmpty()) {
//        				System.out.printf("%d", dq.removeFirst());
        				sb.append(dq.removeFirst());
//        				if (!dq.isEmpty()) System.out.print(",");
        				if (!dq.isEmpty()) sb.append(",");
        			}
        		} else {
        			while (!dq.isEmpty()) {
//        				System.out.printf("%d", dq.removeLast());
        				sb.append(dq.removeLast());
//        				if (!dq.isEmpty()) System.out.print(",");
        				if (!dq.isEmpty()) sb.append(",");
        			}
        		}
        		
//        		System.out.printf("]\n");
        		sb.append("]");
        		System.out.println(sb.toString());
        	}
        	
        }
    }
}