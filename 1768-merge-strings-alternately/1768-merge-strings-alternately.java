class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (words1.length != idx && words2.length != idx) {
            sb.append(words1[idx]);
            sb.append(words2[idx]);
            idx += 1;
        }

        if (words1.length == idx) {
            while (words2.length != idx) {
                sb.append(words2[idx]);
                idx += 1;
            }
        }

        else {
            while (words1.length != idx) {
                sb.append(words1[idx]);
                idx += 1;
            }
        }

        return sb.toString();
    }
}