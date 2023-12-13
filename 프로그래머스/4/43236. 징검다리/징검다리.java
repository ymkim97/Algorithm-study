import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int remove = 0;
            int point = 0;
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - point < mid) {
                    remove += 1;
                } else {
                    point = rocks[i];
                }
            }
            
            if(distance - point < mid) {
                remove++;
            }
            
            if(remove <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return answer;
    }
}