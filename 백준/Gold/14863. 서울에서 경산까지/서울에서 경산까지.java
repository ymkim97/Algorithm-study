import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int t1, t2, m1, m2;

		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N ; i ++) {
			st = new StringTokenizer(br.readLine());
			t1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());

			if (i == 1) {
				dp[i][t1] = m1;
				dp[i][t2] = Math.max(dp[i][t2], m2);
			}

			else {
				for (int j = 0; j <= K; j++) {
					if (dp[i - 1][j] == 0) continue;

					if (t1 + j <= K) {
						dp[i][t1 + j] = Math.max(dp[i][t1 + j], dp[i - 1][j] + m1);
					}

					if (t2 + j <= K) {
						dp[i][t2 + j] = Math.max(dp[i][t2 + j], dp[i - 1][j] + m2);
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= K; i++) {
			answer = Math.max(answer, dp[N][i]);
		}

		System.out.println(answer);
	}
}
