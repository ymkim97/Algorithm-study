import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = 0;
            int sum = elements[0];
            
            for (int j = 0; j < i - 1; j++) {
                right += 1;
                sum += elements[right];
            }
            
            if (i == n) {
                set.add(sum);
                break;
            }
            
            for (int j = 0; j < n; j++) {
                set.add(sum);
                sum -= elements[left % n];
                left += 1;
                right += 1;
                sum += elements[right % n];
            }
        }
        
        return set.size();
    }
}