import java.util.*;

class Solution {
    
    int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        List<Integer>[] map = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] edge: edges) {
            map[edge[0]].add(edge[1]);
        }
        
        dfs(0, 0, 0, new ArrayList<>(), info, map);
        
        return maxSheep;
    }
    
    private void dfs(int cur, int sheep, int wolf, List<Integer> next, int[] info, List<Integer>[] map) {
        if (info[cur] == 0) sheep += 1;
        else wolf += 1;
        
        if (wolf >= sheep) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> copyNext = new ArrayList<>(next);
        copyNext.remove(Integer.valueOf(cur));
        for (int n : map[cur]) {
            copyNext.add(n);
        }
        
        for (int n : copyNext) {
            dfs(n, sheep, wolf, copyNext, info, map);
        }
    }
}