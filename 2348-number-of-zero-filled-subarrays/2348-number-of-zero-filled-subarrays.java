class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long answer = 0;
        int contiguousZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) contiguousZero += 1;
            else if (contiguousZero != 0) {
                for (int j = 1; j <= contiguousZero; j++) {
                    answer += j;
                }

                contiguousZero = 0;
            }
        }

        if (contiguousZero != 0) {
            for (int j = 1; j <= contiguousZero; j++) {
                    answer += j;
            }
        }

        return answer;
    }
}