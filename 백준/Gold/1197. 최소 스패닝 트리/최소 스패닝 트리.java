import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Queue<int[]> graph = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new int[] {A, B, C});
        }

        int[] parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;

        while (!graph.isEmpty()) {
            int[] now = graph.poll();

            int a = now[0];
            int b = now[1];
            int w = now[2];

            if (find(a, parent) == find(b, parent)) continue;

            union(a, b, parent);
            totalWeight += w;
        }

        System.out.println(totalWeight);
    }

    private static int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x], parent);
    }

    private static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}