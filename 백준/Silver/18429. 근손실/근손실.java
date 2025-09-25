import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] kits = new int[N];

        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new boolean[N], kits, new ArrayList<>(), K);

        System.out.println(answer);
    }

    public static void dfs(boolean[] visited, int[] kits, List<Integer> orderIdx, int K) {
        if (orderIdx.size() == kits.length) {
            int power = 500;

            for (int idx : orderIdx) {
                power += kits[idx];
                power -= K;

                if (power < 500) return;
            }

            answer += 1;

            return;
        }

        for (int i = 0; i < kits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orderIdx.add(i);
                dfs(visited, kits, orderIdx, K);
                visited[i] = false;
                orderIdx.remove(orderIdx.size() - 1);
            }
        }
    }
}
