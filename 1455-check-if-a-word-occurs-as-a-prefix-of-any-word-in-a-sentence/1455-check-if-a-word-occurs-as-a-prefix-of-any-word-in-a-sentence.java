class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splt = sentence.split(" ");

        for (int i = 0; i < splt.length; i++) {
            if (splt[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }
}