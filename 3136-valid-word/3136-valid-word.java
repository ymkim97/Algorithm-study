class Solution {
    public boolean isValid(String word) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        if (word.length() < 3) return false;

        word = word.toLowerCase();

        int vowelCnt = 0;
        int consonantCnt = 0;

        for (char c : word.toCharArray()) {
            if (vowel.contains(c)) vowelCnt += 1;
            else if (Character.isLetter(c)) consonantCnt += 1;
            else if (!Character.isDigit(c)) return false;
        }

        if (vowelCnt == 0 || consonantCnt == 0) return false;

        return true;
    }
}