import java.util.*;

class Solution {
    
    static List<Integer> visit;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visit = new ArrayList<>(Collections.nCopies(dungeons.length, 0));
        
        backtrack(k, dungeons, 0);
        
        return answer;
    }
    
    public void backtrack(int k, int[][] dungeons, int cnt) {

        if(!visit.contains(0)) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visit.get(i) == 0) {
                visit.set(i, 1);
                if(k >= dungeons[i][0]) {
                    backtrack(k - dungeons[i][1], dungeons, cnt + 1);
                }
                else {
                    backtrack(k, dungeons, cnt);
                }
                visit.set(i, 0);
            }
        }
        return;
    }
}