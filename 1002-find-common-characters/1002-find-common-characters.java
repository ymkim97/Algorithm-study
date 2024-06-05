class Solution {
    public List<String> commonChars(String[] words) {
        int[][] cnt = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                cnt[i][c - 'a'] += 1;
            }
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int tmp = 0;
            boolean flag = true;
            for (int j = 0; j < words.length; j++) {
                if (cnt[j][i] != 0 && flag) tmp += cnt[j][i];
                else flag = false;
            }

            if(tmp > 0 && flag) {
                for (int a = 0; a < tmp / words.length; a++)
                    answer.add(String.valueOf((char)(i + 'a')));
            }
        }

        return answer;
    }
}