class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int answer = 0;
        long[] prefixSums = new long[n];

        prefixSums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (prefixSums[i] >= prefixSums[n - 1] - prefixSums[i]) answer += 1;
        }

        return answer;
    }
}
