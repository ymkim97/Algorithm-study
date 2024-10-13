import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for (String[] bk : book_time) {
            String[] start = bk[0].split(":");
            String[] end = bk[1].split(":");
            
            int startInt = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endInt = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            if (!pq.isEmpty() && startInt >= pq.peek() + 10) {
                pq.poll();
            } 
            
            pq.offer(endInt);
            
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}