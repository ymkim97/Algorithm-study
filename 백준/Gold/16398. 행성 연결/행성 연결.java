import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 0:from, 1:to, 2:cost

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int cost= Integer.parseInt(st.nextToken());

                pq.offer(new int[] {i, j, cost});
            }
        }
    
        long answer = 0;

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int a = now[0];
            int b = now[1];
            int cost = now[2];

            if (find(a, parent) == find(b, parent)) continue;

            union(a, b, parent);
            answer += cost;
        }

        System.out.println(answer);
    }

    private static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
