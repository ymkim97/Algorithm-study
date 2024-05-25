class Solution {

    List<String> answer = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, wordDict, new StringBuilder());

        return answer;
    }

    public void backtrack(String s, List<String> wordDict, StringBuilder sb) {
        if (s.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(wordDict.get(i));
                tmp.append(" ");
                backtrack(s.substring(wordDict.get(i).length()), wordDict, tmp);
            }
        }
    }
}