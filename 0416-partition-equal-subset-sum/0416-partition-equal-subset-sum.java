class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) return false;

        int targetSum = sum / 2;

        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int curSum = targetSum; curSum >= num; curSum--) {
                dp[curSum] = dp[curSum] || dp[curSum - num];
                if (dp[targetSum]) return true;
            }
        }

        return dp[targetSum];
    }
}
