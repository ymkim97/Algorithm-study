import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        
        for (char num : number.toCharArray()) {
            if (st.isEmpty()) {
                st.add(num);
                continue;
            }
            
            while (!st.isEmpty() && st.peek() < num && k > 0) {
                st.pop();
                k -= 1;
            }
            
            st.add(num);
        }
        
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k -= 1;
        }
        
        return st.stream().map(s -> s.toString()).collect(Collectors.joining(""));
    }
}