import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, m, parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (find(a) == find(b)) {
				System.out.println(i + 1);
				return;
			}

			else {
				union(a, b);
			}
		}

		System.out.println(0);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parents[b] = a;
		}

		else {
			parents[a] = b;
		}
	}

	public static int find(int num) {
		if (parents[num] == num) return num;

		return parents[num] = find(parents[num]);
	}
}
