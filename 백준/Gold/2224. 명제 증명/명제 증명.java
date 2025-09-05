import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[52][52];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " => ");
        
            char from = st.nextToken().charAt(0);
            char to = st.nextToken().charAt(0);

            int fromIdx;
            int toIdx;

            if (Character.isUpperCase(from)) fromIdx = from - 'A';
            else fromIdx = from - 'a' + 26;

            if (Character.isUpperCase(to)) toIdx = to - 'A';
            else toIdx = to - 'a' + 26;

            if (fromIdx != toIdx)map[fromIdx][toIdx] = true;
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    if (i != j && map[i][k] && map[k][j]) map[i][j] = true;
                }
            }
        }

        int count = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i == j || !map[i][j]) continue;
                count += 1;

                char from;
                char to;

                if (i < 26) from = (char)(i + 'A');
                else from = (char)(i + 'a' - 26);

                if (j < 26) to = (char)(j + 'A');
                else to = (char)(j + 'a' - 26);

                sb.append(from).append(' ').append('=').append('>').append(' ').append(to).append('\n');
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }
}