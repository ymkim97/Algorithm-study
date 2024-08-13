class Solution {

    boolean[] visited;
    List<List<Integer>> answer;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;

        answer = new ArrayList<>();
        visited = new boolean[candidates.length];

        backtrack(0, 0, new ArrayList<>(), target, candidates.length);

        return answer;
    }

    public void backtrack(int idx, int sum, List<Integer> tmp, int target, int N) {
        if (sum > target) return;

        if (sum == target) {
            answer.add(new ArrayList(tmp));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                if (i > idx && candidates[i] == candidates[i - 1]) continue;
                visited[i] = true;
                tmp.add(candidates[i]);
                backtrack(i + 1, sum + candidates[i], tmp, target, N);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
