class Solution {
    public int longestNiceSubarray(int[] nums) {
        int answer = 1;

        int left = 0;
        int right = 0;
        int bin = 0;

        while (left <= right && right < nums.length) {
            if ((bin & nums[right]) == 0) {
                answer = Math.max(answer, right - left + 1);
                bin = bin | nums[right];
                right += 1;
            } else {
                bin = bin ^ nums[left];
                left += 1;
            }
        }

        return answer;
    }
}