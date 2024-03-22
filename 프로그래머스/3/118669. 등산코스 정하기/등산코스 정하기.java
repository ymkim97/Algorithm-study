import java.util.*;

class Solution {
    
    List<int[]>[] map;
    Set<Integer> summitType = new HashSet<>();
    Set<Integer> gateType = new HashSet<>();
    int[] answer = new int[2];
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        map = new ArrayList[n + 1];
        
        for (int gate : gates) {
            gateType.add(gate);
        }
        
        for (int summit : summits) {
            summitType.add(summit);
        }
        
        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int w = path[2];
            
            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();
            
            if (summitType.contains(a) || gateType.contains(b)) { // 산봉우리 출발 또는 게이트 도착
                map[b].add(new int[]{a, w});
            } else if (summitType.contains(b) || gateType.contains(a)) {
                map[a].add(new int[]{b, w});
            } else {
                map[a].add(new int[]{b, w});
                map[b].add(new int[]{a, w});
            }            
        }
                
        dijkstra(gates, summits);
        return answer;
    }
    
    public void dijkstra(int[] gates, int[] summits) {
        Queue<int[]> q = new LinkedList<>();
        int[] dis = new int[map.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        for (int gate : gates) {
            q.offer(new int[]{gate, 0});
            dis[gate] = 0;
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int e = now[0];
            int w = now[1];
            
            if (dis[e] < w) continue;
            
            for (int[] next : map[e]) {
                int tmp = Math.max(dis[e], next[1]);
                
                if (dis[next[0]] > tmp) {
                    dis[next[0]] = tmp;
                    q.offer(new int[]{next[0], tmp});
                }
            }
        }
        
        int minIntensity = Integer.MAX_VALUE;
        int summitNum = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        for (int summit : summits) {
            if (dis[summit] < minIntensity) {
                minIntensity = dis[summit];
                summitNum = summit;
            }
        }
        
        answer[0] = summitNum;
        answer[1] = minIntensity;
    }
}