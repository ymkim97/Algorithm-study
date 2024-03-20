import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        if (a.length == 1) return 1;
        if (a.length == 2) return 2;
        
        int leftMin = a[0];
        int[] rightMin = new int[a.length];
        rightMin[a.length - 1] = a[a.length - 1];
        
        for (int i = a.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i + 1]);
        }
        
        for (int i = 0; i < a.length; i++) {
            if (!(a[i] > leftMin && a[i] > rightMin[i])) answer += 1;
            
            leftMin = Math.min(leftMin, a[i]);
        }
        
        return answer;
    }
}