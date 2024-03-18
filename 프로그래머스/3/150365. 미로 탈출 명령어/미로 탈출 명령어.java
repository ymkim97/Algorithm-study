import java.util.*;

class Solution {
    
    int[] mx = {1, 0, 0, -1}; // d, l, r, u
    int[] my = {0, -1, 1, 0};
    StringBuilder sb = new StringBuilder();
    String answer;
    int m, n;
    int r, c;
    int k;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        dfs(x, y, 0);
        
        return answer == null ? "impossible" : answer;
    }
    
    public void dfs(int x, int y, int depth) {
        if (answer != null) return;
        
        if (depth == k) {
            if (x == r && y == c) answer = sb.toString();
            return;
        }
        
        if (!checkDis(x, y, k - depth)) return;
        
        if (!checkEvenOdd(x, y, k - depth)) return;
        
        for (int i = 0; i < 4; i++) {
            int dx = x + mx[i];
            int dy = y + my[i];
            
            if (dx < 1 || dy < 1 || dx > n || dy > m) continue;
            
            if (i == 0) sb.append('d');
            else if (i == 1) sb.append('l');
            else if (i == 2) sb.append('r');
            else if (i == 3) sb.append('u');
            
            dfs(dx, dy, depth + 1);
            
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public boolean checkDis(int x, int y, int length) {
        return (Math.abs(x - r) + Math.abs(y - c)) <= length;
    }
    
    public boolean checkEvenOdd(int x, int y, int length) {
        return ((Math.abs(x - r) + Math.abs(y - c)) - length) % 2 == 0;
    }
}