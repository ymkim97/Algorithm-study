import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        
        else {
            return find(parent[num]);
        }
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
       if (a < b) {
           parent[b] = a;
       }
        
        else {
            parent[a] = b;
        }
    }
}