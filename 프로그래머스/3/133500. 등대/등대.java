import java.util.*;

class Solution {
    
    int answer = 0;
    List<Integer>[] node;
    
    public int solution(int n, int[][] lighthouse) {
        node = new ArrayList[n + 1];

        for (int[] house : lighthouse) {
            int a = house[0];
            int b = house[1];
            
            if (node[a] == null) node[a] = new ArrayList<>();
            if (node[b] == null) node[b] = new ArrayList<>();
            
            node[a].add(b);
            node[b].add(a);
        }
        
        dfs(1, 0);
        
        return answer;
    }
    
    public int dfs(int n, int parent) {
        if (node[n].size() == 1 && node[n].get(0) == parent) return 1;
        
        int tmp = 0;
        for (int child : node[n]) {
            if (child == parent) continue;
            
            tmp += dfs(child, n);
        }
        
        if (tmp > 0) answer += 1;
        
        if (tmp == 0) return 1;
        
        return 0;
    }
}