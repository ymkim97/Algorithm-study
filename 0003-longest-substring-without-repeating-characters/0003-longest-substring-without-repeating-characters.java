class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int answer = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (left == right) {
                set.add(s.charAt(right));
                answer = Math.max(answer, 1);
                right += 1;
                continue;
            }

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left += 1;
            }

            set.add(s.charAt(right));
            answer = Math.max(answer, right - left + 1);
            right += 1;
        }

        return answer;
    }
}