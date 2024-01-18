import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int end1, end2;
    static List<Node>[] map;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int answer = 1;
     
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        map = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        } 
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            min = Math.min(min, c);
            max = Math.max(max, c);
            
            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        end1 = Integer.parseInt(st.nextToken());
        end2 = Integer.parseInt(st.nextToken());
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (bfs(mid)) {
                answer = mid;
                min = mid + 1;
            }
            
            else {
                max = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean bfs(int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(end1, 0));
        visited[end1] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.idx == end2) return true;
            
            for (int i = 0; i < map[now.idx].size(); i++) {
                Node next = map[now.idx].get(i);
                
                if (next.cost >= weight && !visited[next.idx]) {
                    visited[next.idx] = true;
                    q.offer(next);
                }
            }
        }
        
        return false;
    }
    
    static class Node {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}