import java.io.*;
import java.util.*;

class Main {
    
    static int N, M, D;
    static char[][] map, expected;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<int[]> start = new ArrayList<>();
     
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        expected = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
         
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'O') {
                    start.add(new int[] {i, j});
                }
            }
        }
        
        D = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            expected[i] = br.readLine().toCharArray();
        }
        
        start.forEach(a -> bfs(a[0], a[1]));
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != expected[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println("YES");
    }
    
    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int dx = x - D; dx <= x + D; dx++) {
                for (int dy = y - D; dy <= y + D; dy++) {
                    if (dx < 0 || dy < 0 || dx >= N || dy >= M || Math.abs(x - dx) + Math.abs(y - dy) > D|| visited[dx][dy]) continue;
                
                    visited[dx][dy] = true;
                    if (expected[dx][dy] != 'O') continue;
                    
                    map[dx][dy] = 'O';
                    q.offer(new int[] {dx, dy});
                }
            }
        }
    }
}