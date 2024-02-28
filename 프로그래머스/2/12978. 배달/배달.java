import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N + 1];
        List<int[]> map[] = new ArrayList[N + 1];
        
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];
            
            map[a].add(new int[] {b, cost});
            map[b].add(new int[] {a, cost});
        }
        
        Arrays.fill(distance, 500_001);
        
        distance[1] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 1});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int now = cur[1];
            
            if (distance[now] < dist) continue;
            
            for (int[] next : map[now]) {
                int sum = dist + next[1];
                
                if (sum < distance[next[0]]) {
                    distance[next[0]] = sum;
                    pq.offer(new int[] {sum, next[0]});
                }
            }
        }

        for (int d : distance) {
            if (d <= K) answer += 1;
        }
        
        return answer;
    }
}