import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] usado = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            usado[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            usado[a].add(new int[] {b, cost});
            usado[b].add(new int[] {a, cost});
        }

        for (int i = 0; i < Q; i++) {
            int answer = 0;
            boolean[] visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            q.offer(v);
            visited[v] = true;

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int[] arr : usado[now]) {
                    int next = arr[0];
                    int cost = arr[1];

                    if (visited[next] || cost < k) continue;

                    answer += 1;
                    visited[next] = true;
                    q.add(next);
                }
            }

            System.out.println(answer);
        }
    }
}