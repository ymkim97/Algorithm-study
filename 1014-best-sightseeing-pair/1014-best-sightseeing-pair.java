class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0];
        int result = 0;

        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }

        return result;
    }
}