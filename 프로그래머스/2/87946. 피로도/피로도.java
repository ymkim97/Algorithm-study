import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        
        for (int i = 0; i < n; i++) {
            if (k < dungeons[i][0]) continue;
            
            visited = new boolean[dungeons.length];
            visited[i] = true;
            
            dfs(k - dungeons[i][1], 1, dungeons);
        }
        
        return answer;
    }
    
    public void dfs(int k, int depth, int[][] dungeons) {
        answer = Math.max(depth, answer);
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            if (k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], depth + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}