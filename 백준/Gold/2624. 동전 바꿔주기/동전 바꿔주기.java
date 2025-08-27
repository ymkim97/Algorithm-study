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

        coins = new int[k][2]; // 0: coinType, 1: coinAmount

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[k][T + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < T; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(comb(0, 0));
    }

    static private int comb(int money, int coinType) {
        if (money == T) return 1;

        if (money > T || coinType == k) return 0;

        if (dp[coinType][money] != -1) return dp[coinType][money];

        int tmp = 0;
        for (int i = 0; i < coins[coinType][1] + 1; i++) {
            int cost = coins[coinType][0] * i;
            tmp += comb(money + cost, coinType + 1);
        }

        return dp[coinType][money] = tmp;
    }
}