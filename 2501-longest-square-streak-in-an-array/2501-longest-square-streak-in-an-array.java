class Solution {
    public int longestSquareStreak(int[] nums) {
        long[] newNums = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums);

        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            long n = newNums[i];
            int count = 1;

            while (true) {
                if (Arrays.binarySearch(newNums, n * n) >= 0) {
                    n *= n;
                    count += 1;
                } else break;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount <= 1 ? -1 : maxCount;
    }
}