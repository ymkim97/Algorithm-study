class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        } else {
            int nines = 0;
            
            for (int d : digits) {
                if (d == 9) nines += 1;
            }

            if (nines == n) {
                int[] answer = new int[n + 1];
                answer[0] = 1;
                return answer;
            } else {
                digits[n - 1] = 0;

                int idx = n - 2;

                while (idx >= 0) {
                    if (digits[idx] != 9) {
                        digits[idx] += 1;
                        break;
                    }

                    digits[idx] = 0;
                    idx -= 1;
                }
            }
        }

        return digits;
    }
}