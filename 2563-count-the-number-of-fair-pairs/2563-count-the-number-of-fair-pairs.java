class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long answer = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + nums[i + 1] > upper) break;
            else if (nums[i] + nums[nums.length - 1] < lower) continue;

            int start = i + 1;
            int end = nums.length - 1;

            int a = lower - nums[i];
            int b = upper - nums[i];

            int aIdx = binarySearchLow(a, nums, start, end);
            int bIdx = binarySearchHigh(b, nums, start, end);

            if (aIdx == -1 || bIdx == -1) continue;
            
            answer += bIdx - aIdx + 1;
        }

        return answer;  
    }

    public int binarySearchLow(int target, int[] nums, int start, int end) {
        int idx = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= target) {
                idx = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return idx;
    }

    public int binarySearchHigh(int target, int[] nums, int start, int end) {
        int idx = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= target) {
                idx = mid;
                start = mid + 1;
            } else end = mid - 1;
        }

        return idx;
    }
}