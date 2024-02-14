import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new int[] {progresses[i], i});
        }
        
        int day = 1;
        while (!q.isEmpty()) {
            int tmpCnt = 0;
            
            while (!q.isEmpty() && q.peek()[0] + speeds[q.peek()[1]] * day >= 100) {
                q.poll();
                tmpCnt += 1;
            }            
            
            if (tmpCnt != 0) {
                answer.add(tmpCnt);
            }

            day += 1;
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}