class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = Arrays.stream(ranks).max().getAsInt();
        long start = 1;
        long end = 1L * cars * cars * maxRank;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(ranks, mid, cars)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(int[] ranks, long maxTime, int cars) {
        long cnt = 0;

        for (int rank : ranks) {
            cnt += (long) Math.sqrt(maxTime / (long)rank);
        }

        return cnt >= cars;
    }
}