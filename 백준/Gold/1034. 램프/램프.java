import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> table = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            table.add(input);
        }

        int K = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String cur = table.get(i);

            if (set.contains(cur)) continue;

            int zeros = 0;
            for (int j = 0; j < M; j++) {
                if (cur.charAt(j) == '0') zeros += 1;
            }

            if (zeros <= K && ((K - zeros) % 2 == 0)) {
                int sameCount = 1;

                for (int j = i + 1; j < N; j++) {
                    if (table.get(j).equals(cur)) sameCount += 1;
                }

                answer = Math.max(answer, sameCount);
            }

            set.add(cur);
        }

        System.out.println(answer);
    }
}
