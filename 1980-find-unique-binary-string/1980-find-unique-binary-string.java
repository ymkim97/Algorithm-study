class Solution {

    String answer;

    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        answer = null;

        for (String n : nums) {
            set.add(n);
        }

        dfs(new StringBuilder(), nums[0].length(), set);

        return answer;
    }

    public void dfs(StringBuilder sb, int maxLength, Set<String> set) {
        if (answer != null) return;

        if (sb.length() == maxLength) {
            if (!set.contains(sb.toString())) answer = sb.toString();

            return;
        }

        sb.append("0");
        dfs(sb, maxLength, set);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        dfs(sb, maxLength, set);
        sb.deleteCharAt(sb.length() - 1);
    }
}