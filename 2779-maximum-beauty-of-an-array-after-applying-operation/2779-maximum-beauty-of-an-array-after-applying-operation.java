class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        if (nums[0] == nums[nums.length - 1]) return nums.length;

        int answer = 1;

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[left] + k >= nums[right] - k) {
                right += 1;
            } else {
                left += 1;
            }

            answer = Math.max(answer, right - left);
            if (right == nums.length) Math.max(answer, right - left + 1);
        }

        return answer;
    }
}

// 1, 2, 4, 6     k = 2

// 34, 52