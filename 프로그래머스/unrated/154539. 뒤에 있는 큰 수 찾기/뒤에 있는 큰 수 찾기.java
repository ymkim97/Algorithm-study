import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stk = new Stack<>();
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        for(int i = 0; i < numbers.length; i++) {
            while (!stk.empty() && numbers[i] > numbers[stk.peek()]) {
                answer[stk.pop()] = numbers[i];
            }
            stk.push(i);
        }
        
        return answer;
    }
}