class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int spaceIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (spaceIdx < spaces.length && spaces[spaceIdx] == i) {
                sb.append(" ");
                spaceIdx += 1;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}