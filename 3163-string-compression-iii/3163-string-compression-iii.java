class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        char last = '#';
        int cnt = 0;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (last == '#' || cnt == 0) {
                last = currentChar;
                cnt += 1;
                continue;
            }

            if (currentChar != last) {
                sb.append(cnt).append(last);
                last = currentChar;
                cnt = 1;
            } else if (currentChar == last && cnt == 8) {
                cnt += 1;
                sb.append(cnt).append(last);
                cnt = 0;
            } else {
                cnt += 1;
            }
        }

        if (cnt > 0) {
            sb.append(cnt).append(last);
        }

        return sb.toString();
    }
}