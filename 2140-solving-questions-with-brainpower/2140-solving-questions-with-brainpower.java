class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        dp[dp.length - 1] = questions[questions.length - 1][0];

        for (int i = questions.length - 2; i >= 0; i--) {
            int[] question = questions[i];
            int point = question[0];
            int brainpower = question[1];

            if (i + brainpower + 1 < questions.length) {
                dp[i] = Math.max(dp[i + 1], point + dp[i + brainpower + 1]);
            } else {
                dp[i] = Math.max(dp[i + 1], point);
            }
        }

        return dp[0];
    }
}