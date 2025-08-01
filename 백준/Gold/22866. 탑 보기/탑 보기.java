import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[] buildings = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	buildings[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] cnt = new int[N + 1];
        int[][] nearest = new int[N + 1][2]; // 0: number, 1: dist
        
        for (int i = 1; i <= N; i++) {
        	Arrays.fill(nearest[i], 100001);
        }
        
        Stack<int[]> stk = new Stack<>(); // 0: number, 1: height
        
        for (int i = 1; i <= N; i++) {
        	
        	while (!stk.isEmpty() && stk.peek()[1] <= buildings[i]) {
        		stk.pop();
        	}
        	
        	cnt[i] += stk.size();
        	
        	if (!stk.isEmpty()) {
        		if (Math.abs(i - stk.peek()[0]) < nearest[i][1]) {
        			nearest[i][0] = stk.peek()[0];
        			nearest[i][1] = Math.abs(i - stk.peek()[0]);
        		} else if (Math.abs(i - stk.peek()[0]) == nearest[i][1] && stk.peek()[0] < nearest[i][0]) {
        			nearest[i][0] = stk.peek()[0];
        		}
        	}
        	
        	stk.push(new int[] {i, buildings[i]});
        }
        
        stk = new Stack<>();
        
    	for (int i = N; i >= 1; i--) {
        	
        	while (!stk.isEmpty() && stk.peek()[1] <= buildings[i]) {
        		stk.pop();
        	}
        	
        	cnt[i] += stk.size();
        	
        	if (!stk.isEmpty()) {
        		if (Math.abs(i - stk.peek()[0]) < nearest[i][1]) {
        			nearest[i][0] = stk.peek()[0];
        			nearest[i][1] = Math.abs(i - stk.peek()[0]);
        		} else if (Math.abs(i - stk.peek()[0]) == nearest[i][1] && stk.peek()[0] < nearest[i][0]) {
        			nearest[i][0] = stk.peek()[0];
        		}
        	}
        	
        	stk.push(new int[] {i, buildings[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= N; i++) {
        	if (cnt[i] == 0) {
        		sb.append(0).append("\n");
        	} else {
        		sb.append(cnt[i]).append(" ").append(nearest[i][0]).append("\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}
