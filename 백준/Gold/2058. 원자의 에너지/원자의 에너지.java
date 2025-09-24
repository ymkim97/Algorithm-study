import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, long[]> dp = new HashMap<>(); //0: notTaken, 1: taken
    static Set<Integer> visited = new HashSet<>();
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> nodes = new HashSet<>();

        for (int i = 0; i < N; i++) {
            nodes.add(Integer.parseInt(br.readLine()));
        }

        int[] additional = new int[M];

        for (int j = 0; j < M; j++) {
            additional[j] = Integer.parseInt(br.readLine());
        }

        map = new HashMap<>();
        for (int n : nodes) {
            map.putIfAbsent(n, new ArrayList<>());

            for (int a : additional) {
                if (nodes.contains(n + a)) {
                    map.get(n).add(n + a);
                }
                if (nodes.contains(n - a)) {
                    map.get(n).add(n - a);
                }
            }
        }

        long answer = 0;

        for (int n : nodes) {
            if (!visited.contains(n)) {
                dfs(n, -1);
                answer += Math.max(dp.get(n)[0], dp.get(n)[1]);
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int n, int parent) {
        visited.add(n);

        long notTaken = 0;
        long taken = n;

        for (int next : map.get(n)) {
            if (next == parent) continue;

            dfs(next, n);
            notTaken += Math.max(dp.get(next)[0], dp.get(next)[1]);
            taken += dp.get(next)[0];
        }

        dp.put(n, new long[] {notTaken, taken});
    }
}
