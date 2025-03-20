import java.util.Arrays;

class Solution {

    int[] parent;
    int[] costs;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        costs = new int[n];

        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // 모든 간선을 다시 확인하여 최소 비용을 정확히 갱신
        for (int[] edge : edges) {
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            int cost = edge[2];

            costs[rootA] &= cost;
            costs[rootB] &= cost;
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int a = query[i][0];
            int b = query[i][1];

            if (find(a) != find(b)) {
                answer[i] = -1;
            } else {
                answer[i] = costs[find(a)];
            }
        }

        return answer;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }
}
