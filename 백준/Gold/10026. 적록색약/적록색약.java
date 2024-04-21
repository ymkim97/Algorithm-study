import java.io.*;
import java.util.*;

class Main {

    static char[][] map;
    static boolean[][] visited;
    static int firstAnswer = 0;
    static int secondAnswer = 0;
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) bfs(i, j, false);
            }
        }
        
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) bfs(i, j, true);
            }
        }
        
        System.out.printf("%d %d", firstAnswer, secondAnswer);
    }
    
    public static void bfs(int a, int b, boolean isColorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        char c = map[a][b];
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length || visited[dx][dy]) continue;
                if (c != map[dx][dy]) continue;
                
                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }
        
        if (isColorBlind) {
            secondAnswer += 1;
        } else {
            firstAnswer += 1;
        }
    }
}