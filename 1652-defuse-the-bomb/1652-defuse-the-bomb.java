class Solution {
    public int[] decrypt(int[] code, int k) {
        int N = code.length;

        int[] answer = new int[N];

        if (k == 0) return answer;

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            int idx = i;

            if (k > 0) {
                for (int t = 1; t <= k; t++) {
                    idx = (idx + 1) % N;
                    tmp += code[idx];
                }
            } else {
                for (int t = 1; t <= Math.abs(k); t++) {
                    idx = idx - 1;
                    if (idx < 0) idx = N - 1;
                    tmp += code[idx];
                }
            }

            answer[i] = tmp;
        }

        return answer;
    }
}