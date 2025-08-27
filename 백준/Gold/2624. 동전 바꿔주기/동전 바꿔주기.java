import java.io.*;
import java.util.*;

public class Main {

    static int T,k;
    static int[][] coins;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        coins = new int[k + 1][2]; // 0: coinType, 1: coinAmount

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());

            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[k + 1][T + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
                int amount = coins[i][0];
            for (int j = 0; j < coins[i][1] + 1; j++) {
                for (int m = 0; m <= T; m++) {
                    int cost = m + amount * j;

                    if (cost > T) break;

                    dp[i][cost] += dp[i - 1][m];
                }
            }
        }

        System.out.println(dp[k][T]);
    }
}