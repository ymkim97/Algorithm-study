class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = Arrays.stream(quantities).max().getAsInt();
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid, quantities, n)) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return answer;
    }

    public boolean check(int div, int[] quantities, int n) {
        int tmp = 0;

        for (int q : quantities) {
            tmp += (int)Math.ceil((double)q / div);
        }

        return tmp <= n ? true : false;
    }
}