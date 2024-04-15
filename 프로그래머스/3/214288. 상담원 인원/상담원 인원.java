import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        List<Time>[] timeForEach = new ArrayList[k + 1];
        for (int i = 1; i < k + 1; i++) {
            timeForEach[i] = new ArrayList<>();
        }
        
        for (int[] req : reqs) {
            int start = req[0];
            int dur = req[1];
            int type = req[2];
            
            timeForEach[type].add(new Time(start, start + dur));
        }
        
        int[][] wait = new int[k + 1][n + 1];
        for (int type = 1; type < k + 1; type++) {
            if (timeForEach[type].size() == 0) continue;
            
            for (int a = 1; a <= (n - k) + 1; a++) {
                int waitTime = calculateWait(timeForEach[type], a);
                wait[type][a] = waitTime;
            }
        }
        
        int[] currentAdvisors = new int[k + 1];
        for (int type = 1; type < k + 1; type++) {
            currentAdvisors[type] = 1;
        }
        
        int remains = n - k;
        
        while (remains > 0) {
            int maxReduce = 0;
            int corType = 0;
            
            for (int type = 1; type < k + 1; type++) {
                int currentTypeCount = currentAdvisors[type];
                int waitOfCurrent = wait[type][currentTypeCount];
                int waitOfNext = wait[type][currentTypeCount + 1];
                int reduceTime = Math.abs(waitOfCurrent - waitOfNext);
                
                if (reduceTime >= maxReduce) {
                    maxReduce = reduceTime;
                    corType = type;
                }
            }
            
            if (maxReduce == 0) break;
            
            currentAdvisors[corType] += 1;
            remains -= 1;
        }
        
        for (int type = 1; type < k + 1; type++) {
            if (timeForEach[type].size() == 0) continue;
            
            int ad = currentAdvisors[type];
            
            answer += wait[type][ad];
        }
        
        return answer;
    }
    
    public int calculateWait(List<Time> times, int advisorNumber) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;
        
        for (Time t : times) {
            if (pq.isEmpty() || pq.size() < advisorNumber) {
                pq.add(t.end);
            } else {
                int last = pq.poll();
                
                if (t.start < last) {
                    waitTime += last - t.start;
                    pq.add(last + t.end - t.start);
                } else {
                    pq.add(t.end);
                }
            }
        }
        
        return waitTime;
    }
    
    static class Time {
        int start;
        int end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}