class Solution {
    public long flowerGame(int n, int m) {

        int oddFromN = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int oddFromM = m % 2 == 0 ? m / 2 : m / 2 + 1;

        long evenFromN = n / 2;
        long evenFromM = m / 2;

        return oddFromN * evenFromM + oddFromM * evenFromN;
    }
}