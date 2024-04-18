import java.io.*;
import java.util.*;

class Main {
    
    static int[] answer = new int[2];
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        List<Integer>[] toLower = new ArrayList[N + 1];
        List<Integer>[] toHigher = new ArrayList[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (toLower[a] == null) toLower[a] = new ArrayList<>();
            if (toLower[b] == null) toLower[b] = new ArrayList<>();
            if (toHigher[a] == null) toHigher[a] = new ArrayList<>();
            if (toHigher[b] == null) toHigher[b] = new ArrayList<>();
            
            toLower[a].add(b);
            toHigher[b].add(a);
        }
        
        bfs(X, toLower, true);
        bfs(X, toHigher, false);
        
        System.out.printf("%d %d", answer[0], answer[1]);
    }
    
    static public void bfs(int start, List<Integer>[] map, boolean isToLower) {
        int count = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            if (map[now] == null) break;
            
            for (int next : map[now]) {
                if (visited[next]) continue;
                
                visited[next] = true;
                count += 1;
                q.offer(next);
            }
        }
        
        if (isToLower) {
            answer[1] = N - count;
        } else {
            answer[0] = count + 1;
        }
    }
}
