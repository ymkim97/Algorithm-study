class Solution {
    public int findClosest(int x, int y, int z) {
        int xStep = Math.abs(x - z);
        int yStep = Math.abs(y - z);

        if (xStep == yStep) return 0;

        return xStep < yStep ? 1 : 2;
    }
}