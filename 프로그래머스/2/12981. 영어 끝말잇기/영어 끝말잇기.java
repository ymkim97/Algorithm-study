import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int failNum = 0;
        int failNth = 0;
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int curNum = i % n + 1;
            int curNth = i / n + 1;
            
            if (set.contains(word) || (i > 0 && word.charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1))) {
                failNum = curNum;
                failNth = curNth;
                break;
            }
            
            set.add(word);
        }

        return new int[] {failNum, failNth};
    }
}