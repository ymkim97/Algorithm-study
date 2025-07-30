class Solution {
    public int edgeScore(int[] edges) {
        long[] scores = new long[edges.length];

        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
        }

        int answer = 0;
        long max = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                answer = i;
            }
        }

        return answer;
    }
}