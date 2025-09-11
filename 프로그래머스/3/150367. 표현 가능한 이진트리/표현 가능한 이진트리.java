import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, 1);
        
        int answerIdx = 0;
        
        for (long n : numbers) {
            StringBuilder sb = new StringBuilder();
        
            while (n > 0) {
                sb.append(n % 2);
                n /= 2;
            }
            
            sb = sb.reverse();
            
            // 길이 맞추기
            int height = 0;
            int length = sb.length();
            
            while (true) {
                if ((Math.pow(2, height) - 1) >= sb.length()) {
                    for (int i = 0; i < (Math.pow(2, height) - 1) - length; i++) {
                        sb.insert(0, "0");
                    }
                    
                    break;
                }
                
                height += 1;
            }
            
            String binary = sb.toString();
            
            if (binary.charAt(binary.length() / 2) == 0) {
                answer[answerIdx] = 0;
            } else {
                dfs(0, binary.length() - 1, binary, answer, answerIdx);
            }
            
            answerIdx += 1;
        }
        
        return answer;
    }
    
    private void dfs(int left, int right, String binary, int[] answer, int answerIdx) {
        if (left == right) return;
        
        int mid = (left + right) / 2;
        char cur = binary.charAt(mid);
        
        if (cur == '0' && (binary.substring(left, mid).contains("1") || binary.substring(mid, right + 1).contains("1"))) {
            answer[answerIdx] = 0;
        } else {
            dfs(left, mid - 1, binary, answer, answerIdx);
            dfs(mid + 1, right, binary, answer, answerIdx);
        }   
    }
}