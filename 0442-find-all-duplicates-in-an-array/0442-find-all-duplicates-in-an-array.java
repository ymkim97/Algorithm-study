class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                answer.add(num);
            }

            else {
                set.add(num);
            }
        }

        return answer;
    }
}