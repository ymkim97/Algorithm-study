import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        for (long i = left; i < right + 1; i++) {
            long a = i / n;
            long b = i % n;
            
            if (a >= b) {
                answer.add((int)a + 1);
            }
            
            else {
                answer.add((int)b + 1);
            }
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}