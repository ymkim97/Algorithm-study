class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer>[] reverseMap = new ArrayList[n];
        for (int[] edge : edges) {
            int from = edge[1];
            int to = edge[0];

            if (reverseMap[from] == null) reverseMap[from] = new ArrayList<>();
            if (reverseMap[to] == null) reverseMap[to] = new ArrayList<>();

            reverseMap[from].add(to);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();

            if (reverseMap[i].size() > 0) dfs(i, tmp, reverseMap, new boolean[n]);
   
            tmp.remove((Integer) i);
            Collections.sort(tmp);
            answer.add(tmp);
        }

        return answer;
    }

    public void dfs(int num, List<Integer> tmp, List<Integer>[] reverseMap, boolean[] visited) {
        tmp.add(num);

        for (int next : reverseMap[num]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, tmp, reverseMap, visited);
            }
        }
    }
}