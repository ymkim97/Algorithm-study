class Solution {
    public int possibleStringCount(String word) {
        int answer = 0;
        int repeated = 0;
        boolean[] visited = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            int cnt = 1;
            if (!visited[i]) {
                for (int j = i + 1; j < word.length(); j++) {
                    if (word.charAt(i) == word.charAt(j)) {
                        cnt += 1;
                        visited[j] = true;
                    } else {
                        break;
                    }
                }
            }
            
            if (cnt > 1) {
                repeated += 1;
                answer += cnt;
            }
        }

        return answer == 0 ? 1 : answer - repeated + 1;
    }
}