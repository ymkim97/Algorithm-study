import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int answer = 0;
        
        while (!q.isEmpty()) {            
            int[] cur = q.poll();
            
            if (cur[1] < pq.peek()) {
                q.offer(cur);
                continue;
            }
            
            pq.poll();
            answer += 1;
            
            if (cur[0] == location) break;
        }
        
        return answer;
    }
}