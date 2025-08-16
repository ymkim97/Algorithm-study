import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberOfWeight = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] weights = new int[numberOfWeight];
        for (int i = 0; i < numberOfWeight; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int numberOfMarble = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean[][] dp = new boolean[numberOfWeight + 1][15_001];

        dfs(0, 0, dp, weights);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfMarble; i++) {
            int marble = Integer.parseInt(st.nextToken());

            if (marble > 15_000) sb.append("N").append(" ");
            else {
                sb.append(dp[numberOfWeight][marble] ? "Y" : "N").append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int idx, int weight, boolean[][] dp, int[] weights) {
        if (dp[idx][weight]) return;

        dp[idx][weight] = true;

        if (idx == weights.length) return;

        dfs(idx + 1, weight, dp, weights);
        dfs(idx + 1, weight + weights[idx], dp, weights);
        dfs(idx + 1, Math.abs(weight - weights[idx]), dp, weights);
    }
}
