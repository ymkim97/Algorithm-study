class Solution {
    public int minOperations(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int n = (nums[i] + prefixSum[i]) % 2;

            if (n == 0) {
                answer += 1;
                prefixSum[i] += 1;
                prefixSum[i + 1] += 1;
                prefixSum[i + 2] += 1;
            }
        }

        for (int i = nums.length - 3; i < nums.length; i++) {
            if ((nums[i] + prefixSum[i]) % 2 != 1) {
                return -1;
            }
        }

        return answer;
    }
}