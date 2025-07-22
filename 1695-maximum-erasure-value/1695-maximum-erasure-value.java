class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int answer = 0;
        int sum = 0;

        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left += 1;
            }

            set.add(nums[right]);
            sum += nums[right];
            answer = Math.max(answer, sum);

            right += 1;
        }

        return answer;
    }
}