import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> cities = new ArrayList<>();
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cities.add(y);
        }
        
        Stack<Integer> stk = new Stack<>();
        for (int h : cities) {
            while (!stk.isEmpty() && h < stk.peek()) {
                stk.pop();
                answer += 1;
            }
            
            if (!stk.isEmpty() && stk.peek() == h) continue;
            
            stk.push(h);
        }
        
        while (!stk.isEmpty()) {
           if (stk.peek() > 0) answer += 1;
           stk.pop();
        }
        
        System.out.println(answer);
    }
}