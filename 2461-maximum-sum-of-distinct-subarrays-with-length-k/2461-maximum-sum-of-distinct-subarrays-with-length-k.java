class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = -1;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            right += 1;
            sum += nums[i];
        }

        if (map.size() == k) answer = sum;

        for (int i = 0; i < nums.length - k; i++) {
            right += 1;
            sum += nums[right];
            sum -= nums[left];

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            map.put(nums[left], map.get(nums[left]) - 1);

            if (map.get(nums[left]) == 0) map.remove(nums[left]);

            left += 1;

            if (map.size() == k) answer = Math.max(answer, sum);
        }

        return answer;
    }
}
