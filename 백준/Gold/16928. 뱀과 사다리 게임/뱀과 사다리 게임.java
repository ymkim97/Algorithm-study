import java.io.*;
import java.util.*;

class Main {
    
    static int[] map = new int[101];
    static boolean[] visited = new boolean[101];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map[a] = b;
        }
        
        bfs(1);
    }
    
    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.offer(new int[] {start, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int number = now[0];
            int count = now[1];
            
            if (number == 100) {
                System.out.println(count);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                if (number + i > 100 || visited[number + i]) continue;
                
                visited[number + i] = true;
                
                if (map[number + i] == 0){
                    q.offer(new int[] {number + i, count + 1});
                }
                
                else {
                    visited[map[number + i]] = true;
                    q.offer(new int[] {map[number + i], count + 1});
                }
            }
        }
    }
}