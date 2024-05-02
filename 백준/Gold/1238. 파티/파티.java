import java.io.*;
import java.util.*;

class Main {
    
    static int N, X;
    static List<int[]>[] map;
    static int[][] distances;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        map = new ArrayList[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if (map[from] == null) map[from] = new ArrayList<>();
            
            map[from].add(new int[] {to, cost});
        }
        
        distances = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int[] tmp = new int[N + 1];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            distances[i] = tmp;
            dijkstra(i);
        }
        
        int answer = 0;
        
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, distances[i][X] + distances[X][i]);
        }
        
        System.out.println(answer);
    }
    
    public static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            
            return a[1] - b[1];
        });
     
        pq.offer(new int[] {0, start});
        distances[start][start] = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int dist = now[0];
            int num = now[1];
            
            if (distances[start][num] < dist) continue;
            
            for (int[] next : map[num]) {
                int tmp = dist + next[1];
                
                if (tmp < distances[start][next[0]]) {
                    distances[start][next[0]] = tmp;
                    pq.offer(new int[] {tmp, next[0]});
                }
            }
        }
        
    }
}