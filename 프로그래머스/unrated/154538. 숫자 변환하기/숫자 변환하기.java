import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] visit = new int[y + 1];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visit, 0);
        
        q.add(x);
        
        while (q.size() != 0) {
            int now = q.poll();
            
            if (now == y) {
                answer = visit[now];
                break;
            }
            
            if (now + n <= y && visit[now + n] == 0) {
                visit[now + n] = visit[now] + 1;
                q.add(now + n);
            }
            
            if (now * 2 <= y && visit[now * 2] == 0) {
                visit[now * 2] = visit[now] + 1;
                q.add(now * 2);
            }
            
            if (now * 3 <= y && visit[now * 3] == 0) {
                visit[now * 3] = visit[now] + 1;
                q.add(now * 3);
            }
            
        }
        
        return answer;
    }

}