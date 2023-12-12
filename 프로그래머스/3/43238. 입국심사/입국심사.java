import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        int mostLong = times[times.length - 1];
        long left = 0;
        long right = (long)n * mostLong;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}