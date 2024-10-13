import java.util.*;

class Solution {
    public String solution(String number, int k) {        
        Stack<Character> stack = new Stack<>();
        int removedCnt = 0;
        
        for (char n : number.toCharArray()) {
            while (removedCnt < k && !stack.isEmpty() && stack.peek() < n) {
                removedCnt += 1;
                stack.pop();
            }
            
            stack.push(n);
        }
        
        while (removedCnt < k) {
            stack.pop();
            removedCnt += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}