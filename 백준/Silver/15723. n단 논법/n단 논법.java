import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<Character>[] map = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            map[i] = new ArrayList<>();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" is ");

            char from = parts[0].charAt(0);
            char to = parts[1].charAt(0);

            map[from - 'a'].add(to);
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" is ");

            char from = parts[0].charAt(0);
            char to = parts[1].charAt(0);

            if (dfs(from, to, map, new HashSet<>(), 0) > 0) sb.append("T\n");
            else sb.append("F\n");
        }

        System.out.println(sb.toString());
    }

    private static int dfs(char from, char to, List<Character>[] map, Set<Character> visited, int depth) {

        List<Character> next = map[from - 'a'];

        for (char c : next) {
            if (visited.contains(c)) continue;
            visited.add(c);

            if (c == to) return 1;
            else return dfs(c, to, map, new HashSet<>(visited), depth + 1);
        }

        return 0;
    }
}
