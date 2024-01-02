import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        Queue<int[]> startQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> durationQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for (int[] job : jobs) {
            startQ.offer(job);
        }
        
        while(!startQ.isEmpty() || !durationQ.isEmpty()) {
            
            while (!startQ.isEmpty() && startQ.peek()[0] <= time) {
                durationQ.offer(startQ.poll());
            }
            
            if (durationQ.isEmpty()) {
                time = startQ.peek()[0];
            }
            
            else {
                int[] job = durationQ.poll();
                answer += time + job[1] - job[0];
                time += job[1];
            }
        }
        
        return answer / jobs.length;
    }
}