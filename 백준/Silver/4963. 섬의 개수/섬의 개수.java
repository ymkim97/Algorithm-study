import java.io.*;
import java.util.*;

class Main {

    static int[] mx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] my = {0, 0, 1, -1, 1, -1, 1, -1};
    static int h, w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) return;
            
            int[][] map = new int[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int countLand = 0;
            
            boolean[][] visited = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j, map, visited);
                        countLand += 1;
                    }
                }
            }
            
            System.out.println(countLand);
        }
    }
    
    public static void bfs(int a, int b, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 8; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= h || dy >= w || visited[dx][dy]) continue;
                if (map[dx][dy] == 0) continue;
                
                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }
    }
}