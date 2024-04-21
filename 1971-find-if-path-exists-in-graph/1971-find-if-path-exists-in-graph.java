class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] map = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();

            map[a].add(b);
            map[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == destination) return true;

            for (int next : map[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.offer(next);
            }
        }

        return false;
    }
}