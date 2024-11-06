class Solution {
    public boolean canSortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if (!checkSetBits(nums[j], nums[j + 1])) return false;

                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }   
        }

        return true;
    }

    public boolean checkSetBits(int a, int b) {
        String strA = toBin(a);
        String strB = toBin(b);

        int tmpA = 0;
        int tmpB = 0;

        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == '1') tmpA += 1;
        }

        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == '1') tmpB += 1;
        }

        return tmpA == tmpB ? true : false;
    }
    
    public String toBin(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString();
    }
}