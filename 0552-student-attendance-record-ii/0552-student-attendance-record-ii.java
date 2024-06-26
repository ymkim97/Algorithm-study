class Solution {
    public int checkRecord(int n) {
        int MOD = (int) (1e9 + 7);

        long[] p = new long[n + 1];
        long[] l = new long[n + 1];

        p[0] = p[1] = l[1] = 1;

        for (int i = 2; i <= n; i++) {
            p[i] = (p[i - 1] + l[i - 1]) % MOD;
            l[i] = (p[i - 1] + p[i - 2]) % MOD;
        }

        long res = (p[n] + l[n]) % MOD;

        for (int i = 0; i < n; i++) {
            long s = ((p[i] + l[i]) % MOD * (p[n - i - 1] + l[n - i - 1]) % MOD) % MOD;
            res = (res + s) % MOD;
        }

        return (int)res;
    }
}