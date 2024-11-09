class Solution {
    public long minEnd(int n, int x) {
        long a = x;

        n -= 1;

        while (n > 0) {
            a = (a + 1) | x;
            n -= 1;
        }

        return a;
    }
}