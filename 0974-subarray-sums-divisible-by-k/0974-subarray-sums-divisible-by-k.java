class Solution {
        public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();

        count.put(0, 1);

        int prefix = 0, res = 0;

        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}