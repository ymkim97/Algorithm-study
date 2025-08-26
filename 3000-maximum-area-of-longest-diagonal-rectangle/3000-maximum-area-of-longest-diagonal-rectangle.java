class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double longestDiagonal = 0;
        int area = 0;

        for (int[] dimension: dimensions) {
            int l = dimension[0];
            int w = dimension[1];

            if (Math.sqrt(l * l + w * w) > longestDiagonal || (Math.sqrt(l * l + w * w) == longestDiagonal && l * w > area)) {
                area = l * w;
                longestDiagonal = Math.sqrt(l * l + w * w);
            }
        }

        return area;
    }
}