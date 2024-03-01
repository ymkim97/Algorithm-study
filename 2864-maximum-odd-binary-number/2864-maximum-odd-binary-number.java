class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zeros = 0;
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros += 1;

            else ones += 1;
        }

        StringBuilder sb = new StringBuilder();

        while (ones > 1) {
            sb.append("1");
            ones -= 1;
        }

        while (zeros > 0) {
            sb.append("0");
            zeros -= 1;
        }

        sb.append("1");

        return sb.toString();
    }
}