import java.io.*;
import java.util.*;

class Main {

    static List<Integer> answer = new ArrayList<>();
    static boolean[][] visited;
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) bfs(i, j, M, N, map);
            }
        }
        
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int t : answer) {
            System.out.printf("%d ", t);
        }
    }
    
    public static void bfs(int a, int b, int M, int N, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        int sum = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy] || map[dx][dy] == 1) continue;
                
                sum += 1;
                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }
        
        answer.add(sum);
    }
}