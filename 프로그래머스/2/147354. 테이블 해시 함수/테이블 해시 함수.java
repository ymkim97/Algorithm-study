import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<int[]> datas = new ArrayList<>();
        
        for (int[] d : data) {
            datas.add(d);
        }
        
        Collections.sort(datas, (a, b) -> {
            if (a[col - 1] != b[col - 1]) return a[col - 1] - b[col - 1];
            
            return b[0] - a[0];
        });
        
        List<Integer> mods = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int tmp = 0;
            
            for (int n : datas.get(i)) {
                tmp += (n % (i + 1));
            }
            mods.add(tmp);
        }

        answer = mods.get(0);
        
        for (int i = 1; i < mods.size(); i++) {
            answer ^= mods.get(i);
        }
        
        return answer;
    }
}