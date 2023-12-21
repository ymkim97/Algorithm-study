import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) {
            return new int[] {-1};
        }
        
        int div = s / n;
        int rem = s % n;
        
        for (int i = 0; i < n; i++) {
            answer[i] = div;
        }
        
        for (int i = 0; i < rem; i++) {
            answer[n - 1 - i] += 1;
        }
        
        return answer;
    }
}