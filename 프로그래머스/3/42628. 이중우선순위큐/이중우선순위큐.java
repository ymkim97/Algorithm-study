import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] op = operation.split(" ");
            String command = op[0];
            int num = Integer.parseInt(op[1]);
            
            if (command.equals("I")) {
                maxQ.add(num);
                minQ.add(num);
            } 
            
            else {
                if (num == 1) {
                    minQ.remove(maxQ.poll());
                }
                
                else {
                    maxQ.remove(minQ.poll());
                }
            }
        }
        
        answer[0] = maxQ.peek() != null ? maxQ.poll() : 0;
        answer[1] = minQ.peek() != null ? minQ.poll() : 0;

        return answer;
    }
}