import java.util.*;

class Solution {
    
    int answer = 0;
    int[] gInfo;
    int[][] gEdges;
    
    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited);
        
        return answer;
    }
    
    public void dfs(int idx, int sheep, int wolf, boolean[] visited) {
        visited[idx] = true;
        
        if(gInfo[idx] == 0) {
            sheep += 1;
            answer = Math.max(answer, sheep);
        }
        
        else {
            wolf += 1;
        }
        
        if (wolf >= sheep) return;
        
        for (int[] edge : gEdges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                dfs(edge[1], sheep, wolf, Arrays.copyOf(visited, visited.length));           
            }
        }
    }
}