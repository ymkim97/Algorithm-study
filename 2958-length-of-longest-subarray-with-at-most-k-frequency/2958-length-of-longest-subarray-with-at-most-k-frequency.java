class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int answer = 1;

        while (right < nums.length) {
            int num = nums[right];

            if (map.getOrDefault(num, 0) == k) {
                answer = Math.max(answer, right - left);

                while (true) {
                    int leftNum = nums[left];
                    map.put(leftNum, map.get(leftNum) - 1);
                    left += 1;
                    if (leftNum == num) break;
                }
            } 
    
            map.put(num, map.getOrDefault(num, 0) + 1);
            right += 1;
        }

        return answer;
    }
}