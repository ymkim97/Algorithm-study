class Solution {

    int answer = 0;

    public int findTargetSumWays(int[] nums, int target) {
    
        backtrack(target, 1, nums[0], nums);
        backtrack(target, 1, -1 * nums[0], nums);

        return answer;
    }

    public void backtrack(int target, int idx, int sum, int[] nums) {
        if (idx == nums.length) {
            if (sum == target) answer += 1;
            return;
        }

        backtrack(target, idx + 1, sum + nums[idx], nums);
        backtrack(target, idx + 1, sum + (-1 * nums[idx]), nums);
    }
}