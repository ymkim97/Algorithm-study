import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        Queue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for (String[] t : book_time) {
            String[] startStr = t[0].split(":");
            String[] endStr = t[1].split(":");
            
            int start = Integer.parseInt(startStr[0]) * 60 + Integer.parseInt(startStr[1]);
            int end = Integer.parseInt(endStr[0]) * 60 + Integer.parseInt(endStr[1]);
            
            if (pq.isEmpty()) {
                pq.offer(end + 10);
                continue;
            }
            
            if (pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end + 10);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}