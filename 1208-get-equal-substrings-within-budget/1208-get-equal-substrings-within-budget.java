class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            System.out.println(diff[i]);
        }

        int answer = 0;

        int left = 0;
        int right = 0;
        int tmp = 0;

        while (right < s.length() && left < s.length()) {
            tmp += diff[right];

            if (tmp <= maxCost) {
                answer = Math.max(answer, right - left + 1);
                right += 1;
            } else {
                tmp -= diff[left];
                left += 1;
                right += 1;
            }
        }

        return answer;
    }
}