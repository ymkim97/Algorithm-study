class Solution {
    public int missingNumber(int[] nums) {
        int answer = -1;
        
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                answer = i;
                break;
            }
        }

        if (answer == -1) {
            answer = n;
        }

        return answer;
    }
}