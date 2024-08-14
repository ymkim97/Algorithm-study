class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }

        int high = nums[n - 1] - nums[0];


        while (low < high) {
            int mid = (low + high) / 2;

            if (count(nums, mid) < k) {
                low = mid + 1;
            }

            else {
                high = mid;
            }
        }

        return low;
    }

    public int count(int[] a, int mid) {
        int n = a.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j += 1;

            cnt += j - i - 1;
        }

        return cnt;
    }
}