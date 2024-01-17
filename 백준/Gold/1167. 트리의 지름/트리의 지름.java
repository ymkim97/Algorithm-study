import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V;
    static int max = 0;
    static int startNode;
    static List<Node>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        map = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());

                map[n].add(new Node(to, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(startNode, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int sum) {
        if (sum > max) {
            max = sum;
            startNode = start;
        }

        visited[start] = true;

        for (int i = 0; i < map[start].size(); i++) {
            Node node = map[start].get(i);
            if (!visited[node.number]) {
                visited[node.number] = true;
                dfs(node.number, sum + node.cost);
            }
        }
    }

    static class Node {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

}