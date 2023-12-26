import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push('(');
            else if (s.charAt(i) == ')') {
                if (st.isEmpty())
                    return false;
                else
                    st.pop();
            }
        }
        
        if (st.size() == 0)
            return true;
        
        return false;
    }
}