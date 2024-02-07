import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        Queue<Integer> minq = new PriorityQueue<>();
        Queue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String c : numbers) {
            int number = Integer.parseInt(c);
            minq.offer(number);
            maxq.offer(number);
        }
        
        answer += String.valueOf(minq.poll());
        answer += " ";
        answer += String.valueOf(maxq.poll());
        
        return answer;
    }
}