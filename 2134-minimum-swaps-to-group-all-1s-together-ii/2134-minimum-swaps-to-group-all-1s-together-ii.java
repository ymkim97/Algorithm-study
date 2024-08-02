class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;

        for (int n : nums) {
            ones += n;
        }

        int start = 0;
        int end = start + ones - 1;
        int tmp = 0;

        for (int i = start; i <= end; i++) {
            if (nums[i] == 1) tmp += 1;
        }

        int answer = ones - tmp;

        while (start != nums.length) {
            tmp -= nums[start];
            start += 1;

            end = (end + 1) % nums.length;
            tmp += nums[end];

            answer = Math.min(answer, ones - tmp);
        }

        return answer;
    }
}