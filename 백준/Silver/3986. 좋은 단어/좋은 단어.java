import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0 ; i < N; i++) {
            String str = br.readLine();
            if (str.length() % 2 != 0) continue;
            
            if (check(str)) answer++;
        }
        
        System.out.println(answer);
    }
    
    public static boolean check(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stk.isEmpty()) stk.add(c);
            
            else if (stk.peek() == c ){
                while (!stk.isEmpty() && stk.peek() == c) stk.pop();
            }
            
            else {
                stk.add(c);
            }
        }
        
        return stk.isEmpty() ? true : false;
    }
}