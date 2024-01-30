import java.io.*;
import java.util.*;

class Main {
    
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static String word;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        word = br.readLine();
        visited = new boolean[word.length()];
        
        dfs(0, word.length() - 1);
        
        System.out.println(sb.toString());
    }
    
    public static void dfs(int start, int end) {
        if (start > end) return;
        
        int idx = start;
        
        for (int i = start; i <= end; i++) {
            if (word.charAt(i) < word.charAt(idx)) {
                idx = i;
            }
        }
        
        visited[idx] = true;
        
        for (int i = 0; i < word.length(); i++) {
            if (visited[i]) {
                sb.append(word.charAt(i));
            }
        }
        
        sb.append("\n");
        
        dfs(idx + 1, end);
        dfs(start, idx - 1);
    }
}