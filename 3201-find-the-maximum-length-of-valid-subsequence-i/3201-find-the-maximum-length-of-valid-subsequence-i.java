class Solution {
    public int maximumLength(int[] nums) {
        int odds = 0;
        int evens = 0;
        int both = 0;
        int c = nums[0] % 2; // next to be even or odd

        for (int n : nums) {
            if (n % 2 == 0) evens += 1;
            else odds += 1;

            if (n % 2 == c) {
                both += 1;
                c = 1 - c;
            }
        }

        return Math.max(both, Math.max(odds, evens));
    }
}