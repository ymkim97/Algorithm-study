import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Set<Character> vowelSet;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vowelSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        char[] inputChars = new char[C];

        for (int i = 0; i < C; i++) {
            inputChars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(inputChars);

        dfs(0, 0, 0, L, inputChars, new StringBuilder());

        System.out.println(sb.toString());
    }

    public static void dfs(int vowel, int consonant, int idx, int L, char[] inputChars, StringBuilder cur) {
        if (cur.length() == L) {
            if (vowel >= 1 && consonant >= 2) sb.append(cur.toString()).append("\n");
            return;
        }

        for (int i = idx; i < inputChars.length; i++) {
            char c = inputChars[i];

            if (vowelSet.contains(c)) {
                cur.append(c);
                dfs(vowel + 1, consonant, i + 1, L, inputChars, cur);
                cur.deleteCharAt(cur.length() - 1);
            } else {
                cur.append(c);
                dfs(vowel, consonant + 1, i + 1, L, inputChars, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
