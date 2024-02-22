import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        int[] newQ = new int[queue1.length * 2];
        
        for (int i = 0; i < queue1.length; i++) {
            newQ[i] = queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            newQ[queue1.length + i] = queue2[i];
        }
        
        int left = 0;
        int right = queue1.length - 1;
        int cnt = 0;
        long tmp = sum1;
        
        while (right < newQ.length) {
            if (tmp == (sum1 + sum2) / 2) {
                answer = Math.min(answer, cnt);
                break;
            }
            
            else if (tmp < (sum1 + sum2) / 2) {
                if (right + 1 == newQ.length) break;
                
                right += 1;
                tmp += newQ[right];
            }
            
            else {
                tmp -= newQ[left];
                left += 1;
            }
            
            cnt += 1;
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}