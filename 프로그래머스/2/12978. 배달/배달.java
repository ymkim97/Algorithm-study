import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        int[] distance = new int[N + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        List<int[]>[] map = new ArrayList[N + 1]; //0: num, 1: dis
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int d = r[2];
            
            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();
            
            map[a].add(new int[] {b, d});
            map[b].add(new int[] {a, d});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //0: num, 1: dis
        pq.offer(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int n = now[0];
            int dis = now[1];
            
            if (distance[n] < dis) continue;
            
            for (int[] next : map[n]) {
                int nextN = next[0];
                int d = next[1];
                
                if (distance[nextN] > dis + d) {
                    distance[nextN] = dis + d;
                    pq.offer(new int[] {nextN, dis + d});
                }
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (distance[i] <= K) answer += 1;
        }
        
        return answer;
    }
}