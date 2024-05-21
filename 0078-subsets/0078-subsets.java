class Solution {

    List<List<Integer>> answer;
    int N;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        N = nums.length;

        for (int i = 1; i <= N; i++) {
            dfs(i, 0, 0, new ArrayList<>(), nums);
        }

        return answer;
    }

    public void dfs(int targetLength, int length, int idx, List<Integer> lst, int[] nums) {
        if (targetLength == length) {
            answer.add(new ArrayList(lst));
            return;
        }

        for (int i = idx; i < N; i++) {
            lst.add(nums[i]);
            dfs(targetLength, length + 1, i + 1, lst, nums);
            lst.remove(lst.size() - 1);
        }
    }
}