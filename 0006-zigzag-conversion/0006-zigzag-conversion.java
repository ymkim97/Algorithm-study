class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];

        int strDir = 0;
        boolean isDown = true;

        for (int i = 0; i < s.length(); i++) {
            if (strDir < 0) strDir = 1;

            if (sb[strDir] == null) sb[strDir] = new StringBuilder();

            sb[strDir].append(s.charAt(i));

            if (isDown) {
                strDir += 1;
            } else {
                strDir -= 1;
            }

            if (strDir == -1) {
                isDown = true;
                strDir += 2;
            } else if (strDir == numRows) {
                isDown = false;
                strDir -= 2;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (StringBuilder str : sb) {
            if (str != null) answer.append(str);
        }

        return answer.toString();
    }
}
