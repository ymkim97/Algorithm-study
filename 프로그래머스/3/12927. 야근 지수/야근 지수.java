import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            q.offer(work);
        }
        
        while (n > 0) {
            if (q.peek() == 0) {
                return 0;
            }
            
            int work = q.poll();
            q.offer(work - 1);
            n -= 1;
        }
        
        return q.stream().mapToLong(x -> x * x).sum();
    }
}