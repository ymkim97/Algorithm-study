import java.io.*;
import java.util.*;

class Main {
    
    static int answer = -1;
    static List<Integer>[] map;
    static int a, b, n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map[x].add(y);
            map[y].add(x);
        }
        
        bfs(a);
        
        System.out.println(answer);
    }
    
    public static void bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int number = now[0];
            int count = now[1];
            
            if (number == b) {
                answer = count;
                return;
            }
            
            for (int next : map[number]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, count + 1});
                }
            }
        }
    }
}