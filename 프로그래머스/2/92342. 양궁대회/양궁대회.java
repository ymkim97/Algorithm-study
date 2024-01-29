import java.util.*;

class Solution {
    ArrayList<int[]> answer = new ArrayList<>();
    int[] ryan;
    int[] apeach;
    int N;
    int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        N = n;
        apeach = info;
        
        dfs(0, 0);
        
        if (answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        
        return answer.get(0);
    }
    
    public void dfs(int L, int s) {
        if (L == N) {
            int a = 0;
            int r = 0;
            
            for (int i = 0; i <= 10; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) continue;
                if (apeach[i] < ryan[i]) r += 10 - i;
                else a += 10-i;
            }
            
            if (r > a) {
                int diff = r-a;
                if (diff > max) {
                    max = diff;
                    answer.clear();
                    answer.add(ryan.clone());
                }
                else if (diff == max) answer.add(ryan.clone());
            }
        }
        
        else {
            for (int i = s; i < 11; i++) {
                ryan[i]++;
                dfs(L + 1, i);
                ryan[i]--;
            }
        }
    }
}