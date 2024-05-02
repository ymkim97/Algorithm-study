class Solution {
    public int findMaxK(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        Arrays.sort(nums);

        while (left != right) {
            int leNum = Math.abs(nums[left]);
            int riNum = Math.abs(nums[right]);

            if (leNum == riNum && riNum > answer) {
                answer = riNum;
                break;
            } else if (leNum < riNum) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return answer;
    }
}