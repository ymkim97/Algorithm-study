import java.util.*;

class Solution {
    
    boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                break;
            }
            
            if (i == words.length - 1) {
                return 0;
            }
        }

        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String word, String target, String[] words, int depth) {
        if (word.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && calculateDiff(word, words[i])) {
                System.out.println(words[i]);
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean calculateDiff(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int diffCount = 0;
        
        for (int i = 0; i < charA.length; i++) {
            if (charA[i] != charB[i]) {
                diffCount += 1;
            }
        }
        
        return diffCount == 1 ? true : false;
    }
}