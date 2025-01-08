class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) answer += 1;
            }
        }

        return answer;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if (str2.startsWith(str1) && str2.endsWith(str1)) return true;

        return false;
    }
}