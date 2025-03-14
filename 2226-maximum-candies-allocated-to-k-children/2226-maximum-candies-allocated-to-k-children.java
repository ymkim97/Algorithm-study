class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = Arrays.stream(candies).max().getAsInt();

        int start = 0;
        int end = maxCandy;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(candies, mid, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int[] candies, int t, long k) {
        if (t == 0) return true;

        long count = 0;

        for (int c : candies) {
            count += c / t;
        }

        return count >= k;
    }
}