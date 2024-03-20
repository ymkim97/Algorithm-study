/*
 1. "110" 개수 세면서 추출
 2. 남은 숫자에서 0이 나오기 전까지 / 맨 앞까지 가서 110 풀기
*/
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            int count = 0;
            
            LinkedList<Character> dq = new LinkedList<>();
            
            for (char c : str.toCharArray()) {
                if (dq.size() >= 2 && c == '0') {
                    if (dq.peekLast() == '1' && dq.get(dq.size() - 2) == '1') {
                        dq.pollLast();
                        dq.pollLast();
                        count += 1;
                    }
                    
                    else {
                        dq.addLast(c);
                    }
                }
                
                else {
                    dq.addLast(c);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (char c : dq) {
                sb.append(c);
            }
            
            StringBuilder sb2 = new StringBuilder();
            
            while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '1') {
                sb2.insert(sb2.length(), sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }
            
            for (int j = 0; j < count; j++) {
                sb.append("110");
            }
            
            sb.append(sb2.toString());
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}