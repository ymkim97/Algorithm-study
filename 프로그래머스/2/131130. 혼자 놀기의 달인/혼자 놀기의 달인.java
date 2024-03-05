import java.util.*;

class Solution {
    
    boolean[] visited;
    int[] cards;

    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        this.cards = cards;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;
            
            pq.add(dfs(i));
        }
        
        if (pq.size() > 1) {
            answer = 1;
            answer *= pq.poll();
            answer *= pq.poll();
        }
        
        return answer;
    }
    
    public int dfs(int startIdx) {
        if (visited[startIdx]) {
            return 0;
        }
        
        visited[startIdx] = true;
        
        return dfs(cards[startIdx] - 1) + 1;
    }
}