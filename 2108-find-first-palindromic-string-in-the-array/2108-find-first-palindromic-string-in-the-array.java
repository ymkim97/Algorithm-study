class Solution {
    public String firstPalindrome(String[] words) {
        String answer = "";

        for (String word : words) {
            if (validate(word)) {
                answer = word;
                break;
            }
        }

        return answer;
    }

    public boolean validate(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}