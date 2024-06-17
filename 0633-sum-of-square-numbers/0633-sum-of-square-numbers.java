class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);

        while (left <= right) {
            long sum = (long)Math.pow(left, 2) + (long)Math.pow(right, 2);

            if (sum == c) return true;

            else if (sum < c) left += 1;

            else right -= 1;
        }

        return false;
    }
}