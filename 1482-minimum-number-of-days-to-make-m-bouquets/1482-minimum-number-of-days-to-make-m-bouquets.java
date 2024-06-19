class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int availCnt = countAvailable(bloomDay, mid, k);
            
            if (availCnt >= m) {
                answer = mid;
                high = mid - 1;
            }

            else low = mid + 1;
        }

        return answer;
    }

    public int countAvailable(int[] bloomDay, int days, int k) {
        int count = 0;
        int streak = 0;

        for (int b : bloomDay) {
            if (days >= b) streak += 1;
            else streak = 0;

            if (streak == k) {
                streak = 0;
                count += 1;
            }
        }

        return count;
    } 
}