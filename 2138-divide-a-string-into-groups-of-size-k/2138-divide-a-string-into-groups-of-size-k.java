class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] answer = new String[n];

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length() == k) {
                answer[idx] = sb.toString();
                idx += 1;
                sb = new StringBuilder();
            }
        }

        if (n == s.length() / k + 1) {
            while (sb.length() != k) {
                sb.append(fill);
            }
            answer[idx] = sb.toString();
        }

        return answer;
    }
}