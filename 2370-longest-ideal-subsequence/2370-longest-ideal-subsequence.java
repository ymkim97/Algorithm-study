class Solution {
    public int longestIdealString(String s, int k) {
        int left = 0;
        int right = s.length();
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid, s, k)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public boolean check(int len, String s, int k) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length() - len + 1; i++) {
            stk = new Stack<>();
            stk.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (Math.abs(Character.compare(stk.peek(), s.charAt(j))) <= k) {
                    stk.add(s.charAt(j));
                }
            }

            if (stk.size() >= len) return true;
        }

        return false;
    }
}