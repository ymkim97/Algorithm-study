import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            q.offer(new int[] {priorities[i], location == i ? 1 : 0});
        }
       
        int cnt = 1;
        while (!pq.isEmpty()) {
            int targetPriority = pq.poll();
            
            while (q.peek()[0] != targetPriority) {
                q.offer(q.poll());
            }
            
            int[] removed = q.poll();
            
            if (removed[1] == 1) {
                answer = cnt;
            }
            
            cnt += 1;
        }
        
        return answer;
    }
}