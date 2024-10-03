import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0;
        
        while (pq.size() >= 2) {           
            int first = pq.poll();
            int second = pq.poll();
            
            if (first >= K) return cnt;
            
            int mixed = first + second * 2;
            
            pq.offer(mixed);
            
            cnt += 1;
        }
        
        if (pq.isEmpty() || pq.peek() < K) return -1;
        
        return cnt;
    }
}