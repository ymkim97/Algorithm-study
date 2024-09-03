class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        int times = 0;

        while (times != k) {
            int sum = 0;

            for (int i = 0; i < sb.length(); i++) {
                sum += Character.getNumericValue(sb.charAt(i));
            }

            sb = new StringBuilder(String.valueOf(sum));
            times += 1;
        }

        return Integer.parseInt(sb.toString());
    }
}