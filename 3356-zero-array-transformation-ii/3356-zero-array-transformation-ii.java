class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int answer = -1;
        int left = 0;
        int right = queries.length;

        if (!check(nums, queries, right)) return answer;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(nums, queries, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(int[] nums, int[][] queries, int k) {
        int[] tmp = new int[nums.length + 1];

        for (int i = 0; i < k; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int val = queries[i][2];

            tmp[from] += val;
            tmp[to + 1] -= val;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += tmp[i];
            if (sum < nums[i]) return false;
        }

        return true;
    }
}
