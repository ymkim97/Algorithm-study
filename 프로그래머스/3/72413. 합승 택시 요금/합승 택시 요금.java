import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], 20000001);
            map[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int pointA = fares[i][0];
            int pointB = fares[i][1];
            int cost = fares[i][2];
            
            map[pointA][pointB] = cost;
            map[pointB][pointA] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        
        int answer = map[s][a] + map[s][b];
        
        for (int k = 1; k <= n; k ++) {
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }
        
        return answer;
    }
}