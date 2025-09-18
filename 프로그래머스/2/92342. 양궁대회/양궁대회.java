import java.util.*;

class Solution {
    
    int maxDiff = 0;
    int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {

        dfs(n, info, 0, 0, 0, new int[11]);
        
        return maxDiff == 0 ? new int[] {-1} : answer;
    }
    
    private void dfs(int n, int[] info, int ryanSum, int apeachSum, int idx, int[] ryan) {
        if (idx == 11) {
            if (n > 0) ryan[10] += n;  // 남은 화살 전부 0점에
            
            if (ryanSum > apeachSum) {
                int diff = ryanSum - apeachSum;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = Arrays.copyOf(ryan, 11);
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (ryan[i] > answer[i]) {
                            answer = Arrays.copyOf(ryan, 11);
                            break;
                        } else if (ryan[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            
            if (n > 0) ryan[10] -= n;  // 복원
            
            return;
        }
        
        // 1) idx 점수 쏘기
        int need = info[idx] + 1;
        if (n >= need) {
            ryan[idx] = need;
            dfs(n - need, info, ryanSum + (10 - idx), apeachSum, idx + 1, ryan);
            ryan[idx] = 0;
        }
        
        // 2) idx 점수 포기
        int toAdd = info[idx] > 0 ? 10 - idx : 0;
        dfs(n, info, ryanSum, apeachSum + toAdd, idx + 1, ryan);
    }
}
