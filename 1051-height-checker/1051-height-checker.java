class Solution {
    public int heightChecker(int[] heights) {
        int[] original = Arrays.copyOf(heights, heights.length);
        int answer = 0;

        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++) {
            if (original[i] != heights[i]) answer += 1;
        }

        return answer;
    }
}