class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int maxNum = nums[0];
        int minNum = nums[0];

        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(nums[i], nums[i] + maxDp[i - 1]);
            minDp[i] = Math.min(nums[i], nums[i] + minDp[i - 1]);

            maxNum = Math.max(maxNum, maxDp[i]);
            minNum = Math.min(minNum, minDp[i]);
        }

        return Math.max(maxNum, Math.abs(minNum));
    }
}

