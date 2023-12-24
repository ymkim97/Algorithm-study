import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int camera = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (route[0] > camera) {
                camera = route[1];
                answer += 1;
            }
        }
        
        return answer;
    }
}