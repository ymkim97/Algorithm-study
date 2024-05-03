import java.io.*;
import java.util.*;

class Main {
    
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};
    
    static int N, M;
    static int[][] map;
    static List<int[]> viruses = new ArrayList<>();
    static boolean[] virusUsed;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 2) {
                    viruses.add(new int[] {i, j});
                    map[i][j] = 0;
                }
            }
        }
        
        virusUsed = new boolean[viruses.size()];
        
        backtrack(new ArrayList<>(), 0);
        
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        System.out.println(answer);
    }
    
    public static void backtrack(List<int[]> viList, int start) {
        if(viList.size() == M) {
            int time = bfs(viList);
            
            if (time != -1) answer = Math.min(answer, time);
            
            return;
        }
        
        for (int i = start; i < viruses.size(); i++) {
            if (!virusUsed[i]) {
                virusUsed[i] = true;
                viList.add(viruses.get(i));
                backtrack(viList, i);
                viList.remove(viruses.get(i));
                virusUsed[i] = false;
            }
        }
    }
    
    public static int bfs(List<int[]> viList) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] cpyMap = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            cpyMap[i] = Arrays.copyOf(map[i], N);
        }
        
        for (int[] v : viList) {
            q.offer(v);
            visited[v[0]][v[1]] = true;
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy] || cpyMap[dx][dy] == 1) continue;
                
                visited[dx][dy] = true;
                cpyMap[dx][dy] = cpyMap[x][y] + 1;
                q.offer(new int[] {dx, dy});
            }
        }
        
        // scan 작성
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cpyMap[i][j] == 0 && !visited[i][j]) return -1;
                if (visited[i][j]) max = Math.max(max, cpyMap[i][j]);
            }
        }
        
        return max;
    }
}