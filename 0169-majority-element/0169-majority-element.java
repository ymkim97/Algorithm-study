class Solution {
    public int majorityElement(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}