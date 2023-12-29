import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(i);
        }
        
        List<Integer> result = new ArrayList<>();        
        int count = 0;
        int days = 0;
        
        while (!q.isEmpty()) {
            int index = q.poll();            
            int exp = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);
            
            if (exp > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = exp;
            }
            count++;
        }
           
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}