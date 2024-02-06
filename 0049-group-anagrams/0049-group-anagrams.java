class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        String[] cpyStrs = Arrays.copyOf(strs, strs.length);
        boolean[] visited = new boolean[strs.length];

        if (strs.length == 1) {
            answer.add(Arrays.asList(strs[0]));
            return answer;
        }

        for (int i = 0; i < cpyStrs.length; i++) {
            char[] tmp = cpyStrs[i].toCharArray();
            Arrays.sort(tmp);
            cpyStrs[i] = String.valueOf(tmp);
        }

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            
            List<String> tmp = new ArrayList<>();
            String str = strs[i];
            tmp.add(str);

            for (int j = i + 1; j < strs.length; j++) {
                if (cpyStrs[i].equals(cpyStrs[j])) {
                    tmp.add(strs[j]);
                    visited[j] = true;
                }
            }

            answer.add(tmp);
        }

        return answer;
    }
}