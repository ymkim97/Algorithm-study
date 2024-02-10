import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        Arrays.sort(people);
        
        for (int p : people) {
            ad.addLast(p);
        }
        
        while (!ad.isEmpty()) {
            int big = ad.pollLast();
            
            if (!ad.isEmpty() && ad.peekFirst() + big <= limit) {
                ad.pollFirst();
            }
            
            answer += 1;
        }
        
        return answer;
    }
}