import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (String time : timetable) {
            int convertedTime = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3)); // 시간 관련은 하나의 단위로 통일 (분)
            pq.add(convertedTime);
        }
        
        int startTime = 9 * 60;
        int lastTime = 0;
        int peopleCnt = 0;
        
        for (int i = 0; i < n; i++) {
            peopleCnt = 0;
            
            while (!pq.isEmpty()) {
                int currentTime = pq.peek();
                
                if (currentTime <= startTime && peopleCnt < m) {
                    pq.poll();
                    peopleCnt += 1;
                }
                
                else {
                    break;
                }
                
                lastTime = currentTime - 1;
            }
            
            startTime += t;
        }
        
        if (peopleCnt < m) { // 만약 아직 버스의 자리가 남았다면 lastTime을 마지막 버스의 시간으로 변경. 안남았다면 lastTime을 그대로 return.
            lastTime = startTime - t;
        }
        
        String hour = String.format("%02d", lastTime / 60);
        String min = String.format("%02d", lastTime % 60);
        
        return hour + ":" + min;
    }
}