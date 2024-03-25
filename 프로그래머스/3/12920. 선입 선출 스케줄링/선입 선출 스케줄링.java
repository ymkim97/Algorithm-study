import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int low = 1;
        int high = 10_000 * n;
        int time = 0;
        int work = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int count = cal(mid, cores);
            
            if (count >= n) {
                high = mid - 1;
                time = mid;
                work = count;
            } else {
                low = mid + 1;
            }
        }
        
        work -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (work == 0) {
                    return i + 1;
                }
                
                work -= 1;
            }
        }
        
        return answer;
    }
    
    public int cal(int hour, int[] cores) {
        int count = cores.length;
        
        for (int core : cores) {
            count += hour / core;
        }
        
        return count;
    }
}