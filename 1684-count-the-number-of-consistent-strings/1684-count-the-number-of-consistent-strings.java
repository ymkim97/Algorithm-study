class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allows = new boolean[26];

        for (char c: allowed.toCharArray()) {
            allows[c - 'a'] = true;
        }

        int answer = 0;

        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allows[word.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer += 1;
        }

        return answer;
    }
}