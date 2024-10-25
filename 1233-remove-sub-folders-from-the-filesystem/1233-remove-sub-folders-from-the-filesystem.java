class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> answer = new ArrayList<>();

        Arrays.sort(folder);

        for (String f : folder) {
            String[] splt = f.split("/");

            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (String s : splt) {
                sb.append(s);

                if (set.contains(sb.toString())) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer.add(f);
                set.add(sb.toString());
            }
        }

        return answer;
    }
}