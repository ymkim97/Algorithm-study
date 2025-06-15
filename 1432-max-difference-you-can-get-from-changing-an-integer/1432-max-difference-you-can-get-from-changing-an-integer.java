class Solution {
    public int maxDiff(int num) {
        String numStr = Integer.toString(num);
        char firstDigit = numStr.charAt(0);
        String maximum = "";
        String minimum = "";

        if (firstDigit == '9') {
            for (int i = 0; i < numStr.length(); i++) {
                if (numStr.charAt(i) != '9') {
                    firstDigit = numStr.charAt(i);
                    break;
                }
            }
        }
        
        maximum = numStr.replace(firstDigit, '9');

        firstDigit = numStr.charAt(0);

        if (firstDigit == '1') {
            boolean flag = false;

            for (int i = 0; i < numStr.length(); i++) {
                if (numStr.charAt(i) != '1' && numStr.charAt(i) != '0') {
                    firstDigit = numStr.charAt(i);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                minimum = numStr.replace(firstDigit, '0');
            } else {
                minimum = numStr.replace(firstDigit, '1');
            }
        } else {
            minimum = numStr.replace(firstDigit, '1');
        }

        return Integer.parseInt(maximum) - Integer.parseInt(minimum);
    }
}