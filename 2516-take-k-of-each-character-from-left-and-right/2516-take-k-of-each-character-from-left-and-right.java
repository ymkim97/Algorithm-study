class Solution {
    public int takeCharacters(String s, int k) {
        int a = 0;
        int b = 0;
        int c = 0;
        int answer = Integer.MAX_VALUE;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') a += 1;
            else if (ch == 'b') b += 1;
            else c += 1;
        }

        if (k == 0) return 0;
        if (a < k || b < k || c < k) return -1;
        
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);

            if (ch == 'a') a -= 1;
            else if (ch == 'b') b -= 1;
            else c -= 1;

            while (start <= end && (a < k || b < k || c < k)) {
                char toDel = s.charAt(start);

                if (toDel == 'a') a += 1;
                else if (toDel == 'b') b += 1;
                else c += 1;

                start += 1;
            }

            answer = Math.min(answer, s.length() - (end - start + 1));

            end += 1;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}