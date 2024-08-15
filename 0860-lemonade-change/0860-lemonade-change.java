class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2]; // 0: 5, 1: 10

        for (int bill : bills) {
            if (bill == 5) {
                changes[0] += 1;
            }

            else if (bill == 10) {
                if (changes[0] == 0) return false;

                changes[0] -= 1;
                changes[1] += 1;
            }

            else {
                if (changes[0] == 0) return false;

                if (changes[1] == 0) {
                    if (changes[0] < 3) return false;

                    changes[0] -= 3;
                }

                else {
                    changes[0] -= 1;
                    changes[1] -= 1;
                }
            }
        }

        return true;
    }
}