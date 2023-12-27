import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        char[] bracket = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            if (slide(bracket, i)) {
                answer += 1;
            }
        }
        return answer;
    }
    
    public boolean slide(char[] bracket, int number) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < bracket.length; i++) {
            char c = bracket[(i + number) % bracket.length];
            
            switch(c) {
                    case '(' -> stack.push(')');
                    case '{' -> stack.push('}');
                    case '[' -> stack.push(']');
                    case ')', ']', '}' -> {
                        if (stack.isEmpty()) return false;
                        if (stack.pop() != c) return false;
                    } 
            }            
        }
        return stack.isEmpty();
    }
}