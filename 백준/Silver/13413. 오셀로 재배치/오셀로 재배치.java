import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());

            int countW = 0;
            int countB = 0;

            char[] init = br.readLine().toCharArray();
            char[] target = br.readLine().toCharArray();

            for (int i = 0; i < N; i++) {
                if (init[i] == target[i]) continue;

                if (init[i] == 'W') countW += 1;
                else countB += 1;
            }

            sb.append(Math.max(countB, countW)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
