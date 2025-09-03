import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] distances = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0];

            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + distances[i];
            }

            for (int j = 1; j <= M && i > j; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - j][j]);
            }
        }

        System.out.println(dp[N][0]);
    }
}
