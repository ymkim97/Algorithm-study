class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int tmp = 1;
        int answer = 0;
        
        while (right < nums.length) {
            tmp *= nums[right];

            if (tmp < k) {
                answer += 1;
                right += 1;
                if (right >= nums.length && left + 1 < nums.length) {
                    left += 1;
                    tmp = 1;
                    right = left;
                }
            } else {
                left += 1;
                if (left >= nums.length) break;
                tmp = 1;
                right = left;
            }
        }

        return answer;
    }
}