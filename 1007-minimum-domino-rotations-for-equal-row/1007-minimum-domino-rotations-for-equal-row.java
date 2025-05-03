class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] topCount = new int[7];
        int[] botCount = new int[7];
        int[] totCount = new int[7];
        
        for (int i = 0; i < n; i++) {
            int t = tops[i];
            int b = bottoms[i];

            topCount[t] += 1;
            botCount[b] += 1;

            if (t != b) {
                totCount[t] += 1;
                totCount[b] += 1;
            } else {
                totCount[t] += 1;
            }
        }

        boolean isAvail = false;

        for (int i = 1; i <= 6; i++) {
            if (totCount[i] == n) isAvail = true;
        }

        if (!isAvail) return -1;

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            if (totCount[i] == n) {
                int max = Math.max(topCount[i], botCount[i]);

                answer = Math.min(answer, n - max);
            }
        }

        return answer;
    }
}