class Solution {
    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int n = nums.length;
        int left = 0;
        int right = 0;
        int max = Arrays.stream(nums).max().getAsInt();

        while (right != n) {
            int num = nums[right];

            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.getOrDefault(max, 0) >= k && left < right) {
                answer += n - right;

                map.put(nums[left], map.get(nums[left]) - 1);

                left += 1;
            }

            right += 1;
        }

        return answer;
    }
}