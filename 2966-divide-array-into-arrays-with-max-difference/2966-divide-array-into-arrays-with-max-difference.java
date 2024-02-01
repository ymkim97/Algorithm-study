class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] answer = new int[nums.length / 3][3];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i % 3 == 0) {
                answer[i / 3][0] = nums[i];
                continue;
            }

            if (nums[i] - answer[i / 3][0] <= k) {
                answer[i / 3][i % 3] = nums[i];
            }

            else {
                return new int[][] {};
            }
        }

        return answer;
    }
}