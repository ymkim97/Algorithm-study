import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long targetSum = (sum1 + sum2) / 2;
        
        if ((sum1 + sum2) % 2 != 0) return answer;
        
        int[] q = new int[queue1.length + queue2.length];
        
        for (int i = 0; i < queue1.length; i++) {
            q[i] = queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q[queue1.length + i] = queue2[i];
        }
        
        answer = 0;
        int left = 0;
        int right = queue1.length - 1;
        long sum = sum1;
        boolean isAvail = false;
        
        while (right < q.length) {
            if (sum == targetSum) {
                isAvail = true;
                break;
            } else if (sum < targetSum) {
                right += 1;
                if (right == q.length) break;
                
                sum += q[right];
            } else {
                sum -= q[left];
                left += 1;
            }
            
            answer += 1;
        }
        
        
        return isAvail ? answer : -1;
    }
}