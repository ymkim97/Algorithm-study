class Solution {

    int result = 0;
    boolean[] visited;

    public int subsetXORSum(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            visited = new boolean[nums.length];
            backtrack(nums, i, 0, 0, new ArrayList<>());
        }

        return result;
    }

    public void backtrack(int[] nums, int targetLen, int idx, int currentLen, List<Integer> vis) {
        if (currentLen == targetLen) {
            int tmp = 0;

            for (int t : vis) {
                if (tmp == 0) tmp = t;
                else tmp ^= t;
            }

            result += tmp;

            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                vis.add(nums[i]);
                visited[i] = true;
                backtrack(nums, targetLen, i + 1, currentLen + 1, vis);
                vis.remove(vis.size() - 1);
                visited[i] = false;
            }
        }
    }
}