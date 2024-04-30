import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.add(new int[] {nums[i], i});
                continue;
            }
            
            if (nums[i] > stack.peek()[0]) {
                while (!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                    int[] tmp = stack.pop();
                    answer[tmp[1]] = nums[i];
                }
            }
            
            stack.add(new int[] {nums[i], i});
        }
        
        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();
            answer[tmp[1]] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int t : answer) {
            sb.append(t).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}