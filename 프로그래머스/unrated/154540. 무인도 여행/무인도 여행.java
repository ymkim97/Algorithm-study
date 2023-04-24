import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        char[][] arrMaps = new char[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i ++) {
            char[] tmp = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                arrMaps[i][j] = tmp[j];
            }
        }
        
        for(int i = 0; i < maps.length; i ++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if (!visit[i][j] && arrMaps[i][j] != 'X') 
                    bfs(i, j, arrMaps, visit, answer);
            }
        }
        
        
        if (answer.isEmpty()) {
            return new int[] {-1};
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static void bfs(int x, int y, char[][] arrMaps, boolean[][] visit, List<Integer> answer) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = true;
        int total = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            total += (int) arrMaps[now[0]][now[1]] - '0';
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (nx >= 0 && nx < arrMaps.length && ny >= 0 && ny < arrMaps[0].length && !visit[nx][ny] && arrMaps[nx][ny] != 'X') {
                    visit[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
                
            }
        }
        if (total != 0) {
            answer.add(total);
        }
    }
}