import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();

        char last = '#';
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                last = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
                continue;
            }
            
            if (words[i].charAt(0) != last || set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            else {
                last = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
            }
        }

        return answer;
    }
}