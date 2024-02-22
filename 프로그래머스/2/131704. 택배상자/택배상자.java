import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> belt = new LinkedList<>();
        Stack<Integer> subBelt = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            belt.offer(i);
        }
        
        for (int need : order) {
            while (!belt.isEmpty() && belt.peek() < need) {
                subBelt.add(belt.poll());
            }
            
            if (!belt.isEmpty() && belt.peek() == need) {
                belt.poll();
                answer += 1;
                continue;
            }
            
            if (!subBelt.isEmpty() && subBelt.peek() == need) {
                subBelt.pop();
                answer += 1;
            }
            
            else {
                break;
            }
        }
        
        return answer;
    }
}