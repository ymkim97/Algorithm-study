class Solution {
    public int specialArray(int[] nums) {
        int answer = -1;

        for (int i = 0; i <= nums.length; i++) {
            int tmp = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) tmp += 1;
            }

            if (tmp == i) answer = i;
        }

        return answer;
    }
}