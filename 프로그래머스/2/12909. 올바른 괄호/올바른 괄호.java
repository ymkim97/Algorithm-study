import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == ')' && stk.isEmpty()) {
                return false;
            }
            
            else if (c == '(') {
                stk.push(c);
            }
            
            else {
                stk.pop();
            }
        }
        
        if (!stk.isEmpty()) return false;

        return answer;
    }
}