class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(Math.abs(nums[i] - nums[(i + 1) % n]), answer);
        }

        return answer;
    }
}