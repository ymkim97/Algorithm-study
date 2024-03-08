class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());

        int max = values.get(0);
        int answer = 0;

        for (int val : values) {
            if (val < max) break;

            answer += val;
        }

        return answer;
    }
}