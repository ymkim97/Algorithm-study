class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        gaps[n] = eventTime - endTime[n - 1];

        int max = 0;
        int sum = gaps[0];
        int left = 0;
        int right = 0;

        for (int i = 0; i < k; i++) {
            right += 1;
            sum += gaps[right];
        }

        max = sum;

        while (right != n + 1) {
            if (sum > max) max = sum;

            sum -= gaps[left];
            left += 1;
            right += 1;

            if (right == n + 1) break;

            sum += gaps[right];
        }

        return max;
    }
}