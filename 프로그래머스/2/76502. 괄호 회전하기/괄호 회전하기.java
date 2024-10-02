import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        int answer = 0;
        
        for (char c: s.toCharArray()) {
            ad.addLast(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (check(ad)) answer += 1;
            
            ad.addLast(ad.pollFirst());
        }
        
        return answer;
    }
    
    public boolean check(ArrayDeque<Character> ad) {
        Stack<Character> stk = new Stack<>();
        
        for (char c: ad.toArray(new Character[0])) {
            if (c == '(' || c == '{' || c == '[') stk.add(c);
            
            else if (stk.isEmpty() && (c == ')' || c == '}' || c == ']')) return false;
            
            else {
                if (c == ')' && stk.peek() == '(') stk.pop();
                else if (c == '}' && stk.peek() == '{') stk.pop();
                else if (c == ']' && stk.peek() == '[') stk.pop();
                else return false;
            }
        }
        
        return stk.isEmpty() ? true : false;
    }
}