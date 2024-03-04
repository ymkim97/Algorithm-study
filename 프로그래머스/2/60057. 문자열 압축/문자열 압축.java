import java.util.*;

class Solution {
    
    int answer;
    
    public int solution(String s) {
        answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            check(s, i);
        }
        
        return answer;
    }
    
    public void check(String s, int unitLength) {
        List<String> div = new ArrayList<>();
        int idx = 0;
        
        while (idx < s.length()) {
            if (idx + unitLength >= s.length()) {
                div.add(s.substring(idx));
                break;
            }
            
            String newS = s.substring(idx, idx + unitLength);
            div.add(newS);
            
            idx += unitLength;
        }
        
        int tmp = 0;
        boolean[] visited = new boolean[div.size()];
        
        for (int i = 0; i < div.size(); i++) {
            if (visited[i]) continue;
            
            int cnt = 1;
            String now = div.get(i);
            for (int j = i + 1; j < div.size(); j++) {
                if (now.equals(div.get(j))) {
                    visited[j] = true;
                    cnt += 1;
                }
                
                else {
                    break;
                }
            }
            
            tmp += now.length();
            
            if (cnt > 1) {
                tmp += String.valueOf(cnt).length();
            }
        }
        
        answer = Math.min(answer, tmp);
    }
}