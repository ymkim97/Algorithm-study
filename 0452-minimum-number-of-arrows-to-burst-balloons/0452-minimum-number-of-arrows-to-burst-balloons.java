class Solution {
    public int findMinArrowShots(int[][] points) {
        int answer = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int last = Integer.MIN_VALUE;
        for (int[] point : points) {
            if (point[0] > last || (point[0] == Integer.MIN_VALUE && answer == 0)) {
                last = point[1];
                answer += 1;
            }
        }

        return answer;
    }
}