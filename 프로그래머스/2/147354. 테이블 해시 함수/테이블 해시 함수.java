import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) return b[0] - a[0];
            
            return a[col - 1] - b[col - 1];
        });
        
        Queue<Integer> mods = new LinkedList<>();
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int tmp = 0;
            
            for (int n : data[i]) {
                tmp += n % (i + 1);
            }

            mods.offer(tmp);
        }
        
        int answer = mods.poll();
        
        while (!mods.isEmpty()) {
            answer ^= mods.poll();
        }
        
        return answer;
    }
}