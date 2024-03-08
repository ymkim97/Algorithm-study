import java.util.*;

class Solution {
    
    int n, m;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        Map<Integer, Integer> chunks = new HashMap<>();
        int chunkNum = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int size = bfs(land, chunkNum, i, j);
                    chunks.put(chunkNum, size);
                    chunkNum += 1;
                }
            }
        }

        
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            boolean pass = false;
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (pass && land[j][i] != 0) continue;
                
                if (land[j][i] != 0) {
                    pass = true;
                    if (!set.contains(land[j][i])) {
                        tmp += chunks.get(land[j][i]);
                        set.add(land[j][i]);
                    }
                }
                
                else {
                    pass = false;
                }
            }

            answer = Math.max(answer, tmp);
        }
        
        return answer;
    }
    
    public int bfs(int[][] land, int chunkNum, int a, int b) {
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        land[a][b] = chunkNum;
        q.offer(new int[] {a, b});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || land[dx][dy] != 1) continue;
                
                land[dx][dy] = chunkNum;
                size += 1;
                q.offer(new int[] {dx, dy});
            }
        }
        
        return size;
    }
}