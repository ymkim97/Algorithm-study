class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        char firstC = words[0].charAt(0);
        char lastC = words[words.length - 1].charAt(words[words.length - 1].length() - 1);

        if (firstC != lastC) return false;

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) return false;
        }

        return true;
    }
}