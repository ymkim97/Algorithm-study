class Solution {
    int answer = 1;
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, 0);

        return answer;
    }

    public void backtrack(String s, int length, int idx) {
        if (length == s.length()) {
            answer = Math.max(answer, set.size());
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                backtrack(s, length + sb.length(), i + 1);
                set.remove(sb.toString());
            }
        }


    }
}