class Solution {
    public int maximumCount(int[] nums) {
        int answer = 0;
        int n = nums.length;

        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid == 0) break;

            if (nums[mid - 1] < 0 || nums[n - mid] > 0) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}