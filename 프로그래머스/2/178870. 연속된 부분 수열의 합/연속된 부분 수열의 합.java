import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> available = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        while (right < sequence.length) {
            if (sum == k) {
                available.add(new int[] {left, right});
                
                if (right + 1 == sequence.length) break;
                
                right += 1;
                sum += sequence[right];
                sum -= sequence[left];
                left += 1;
            }
            
            else if (sum < k) {
                if (right + 1 == sequence.length) break;
                
                right += 1;
                sum += sequence[right];
            }
            
            else {
                sum -= sequence[left];
                left += 1;
            }
        }
        
        Collections.sort(available, (a, b) -> {
           if ((a[1] - a[0]) != (b[1] - b[0])) return (a[1] - a[0]) - (b[1] - b[0]);
            
            return 0;
        });
        
        return available.get(0);
    }
}