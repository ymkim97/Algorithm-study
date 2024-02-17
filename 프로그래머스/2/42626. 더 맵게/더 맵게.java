import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();

        for (int sc : scoville) {
            pq.offer(sc);
        }
        
        while (!pq.isEmpty()) {
            if (pq.peek() >= K) break;
            
            if (pq.size() == 1) {
                if (pq.peek() < K) answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + (second * 2));
            answer += 1;
        }
        
        return answer;
    }
}