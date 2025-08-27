import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100_001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= i / 2; j++) {
                if (j * j == i) {
                    min = 1;
                    break;
                }
                else min = Math.min(min, dp[j] + dp[i - j]);
            }

            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
