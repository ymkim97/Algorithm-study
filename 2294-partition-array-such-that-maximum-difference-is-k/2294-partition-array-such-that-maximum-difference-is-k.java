class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = 1;
        
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] - nums[left] > k) {
                answer += 1;
                left = right;
            } else {
                right += 1;
            }
        }

        return answer;
    }
}
