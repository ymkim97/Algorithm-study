class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);

        char first = numStr.charAt(0);        
        String min = numStr.replace(first, '0');

        if (first == '9') {
            for (int i = 1; i < numStr.length(); i++) {
                if (numStr.charAt(i) < first) {
                    first = numStr.charAt(i);
                    break;
                }
            }
        }
        String max = numStr.replace(first, '9');

        return Integer.valueOf(max) - Integer.valueOf(min);
    }
}