import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = 0;
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < 24; i++) {
            int player = players[i];
             
            while (!pq.isEmpty() && pq.peek()[0] == i) {
                n -= pq.poll()[1];
            }
            
            int need = player / m;
            int toAdd = need - n;
            
            if (toAdd > 0) {
                n += toAdd;
                answer += toAdd;
                pq.offer(new int[] {i + k, toAdd});
            }
         }
        
        return answer;
    }
}