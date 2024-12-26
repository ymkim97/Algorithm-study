class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int numsSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * numsSum + 1]; // 0: idx, 1: number of reach to sum using idx

        dp[0][nums[0] + numsSum] = 1;
        dp[0][-nums[0] + numsSum] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -numsSum; sum <= numsSum; sum++) {
                if (dp[i - 1][sum + numsSum] > 0) {
                    dp[i][sum + numsSum + nums[i]] += dp[i - 1][sum + numsSum];
                    dp[i][sum + numsSum - nums[i]] += dp[i - 1][sum + numsSum];
                }
            }
        }

        return Math.abs(target) > numsSum ? 0 : dp[nums.length - 1][target + numsSum];
    }
}