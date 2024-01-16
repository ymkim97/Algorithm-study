import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] move;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		move = new int[st.countTokens() - 1];
		for (int i = 0; i < move.length; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[5][5][move.length];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		System.out.println(solve(0, 0, 0));
	}

	static int energy (int pos, int dest) {
		int num = Math.abs(pos - dest);

		if (pos == 0) {
			return 2;
		} else if (num == 0) {
			return 1;
		} else if (num == 2) {
			return 4;
		} else {
			return 3;
		}
	}

	static int solve(int left, int right, int count) {
		if (count == move.length) {
			return 0;
		}

		if (dp[left][right][count] != -1) {
			return dp[left][right][count];
		}

		int l = solve(move[count], right, count + 1) + energy(left, move[count]);
		int r = solve(left, move[count], count + 1) + energy(right, move[count]);

		dp[left][right][count] = Math.min(l, r);

		return dp[left][right][count];
	}
}
