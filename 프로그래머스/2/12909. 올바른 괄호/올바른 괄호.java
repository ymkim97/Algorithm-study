import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c == '(') dq.addFirst(c);
            
            else {
                if (!dq.isEmpty() && dq.getLast() == '(') dq.pollLast();
                else dq.addFirst(c);
            }
        }
        
        return dq.isEmpty() ? true : false;
    }
}