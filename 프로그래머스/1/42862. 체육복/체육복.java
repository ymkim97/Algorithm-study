import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int each : lost) {
            lostSet.add(each);
        }

        for (int each : reserve) {
            reserveSet.add(each);
        }
        
        for (int each : lost) {
            if (reserveSet.contains(each)) {
                reserveSet.remove(each);
                lostSet.remove(each);
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i) && reserveSet.contains(i - 1)) {
                reserveSet.remove(i - 1);
                answer += 1;
            }
            
            else if (lostSet.contains(i) && reserveSet.contains(i + 1)) {
                reserveSet.remove(i + 1);
                answer += 1;
            }
            
            else if (!lostSet.contains(i)) {
                answer += 1;
            }
        }
        
        return answer;
    }
}