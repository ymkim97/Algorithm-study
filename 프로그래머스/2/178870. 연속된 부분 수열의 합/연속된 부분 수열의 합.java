import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> answer = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        while (right < sequence.length) {            
            if (sum < k) {
                right += 1;
                if (right == sequence.length) break;
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left];
                left += 1;
            } else {
                answer.add(new int[] {left, right});
                right += 1;
                if (right == sequence.length) break;
                sum += sequence[right];
            }
        }
        
        Collections.sort(answer, (a, b) -> {
            if ((a[1] - a[0]) == (b[1] - b[0])) return a[0] - b[0];
            
            return (a[1] - a[0]) - (b[1] - b[0]);
        });
        
        return answer.get(0);
    }
}