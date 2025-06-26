class Solution {
    public int longestSubsequence(String s, int k) {
        boolean isOver = false;
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                sb.insert(0, c);
                continue;
            }

            // c == '1'
            if (!isOver) {
                sb.insert(0, c);
                if (!check(sb, k)) {
                    sb.deleteCharAt(0);
                    isOver = true;
                } 
            }
        }

        return sb.length();
    }

    private boolean check(StringBuilder sb, int k) {
        return convertToLong(sb) <= k ? true : false;
    }

    private long convertToLong(StringBuilder sb) {
        int n = 0;
        long total = 0;

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') total += (int)Math.pow(2, n);
            n += 1;
        }

        return total;
    }
}