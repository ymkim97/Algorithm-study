class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int n) {
        int count = 0, i = 0, sum = 0;

        for (int j = 0; j < nums.length; j++) {
            n -= nums[j];

            while (n < 0 && i <= j) {
                n += nums[i++];
            }

            count += j - i + 1;
        }

        System.out.println(count);
        return count;
    }
}