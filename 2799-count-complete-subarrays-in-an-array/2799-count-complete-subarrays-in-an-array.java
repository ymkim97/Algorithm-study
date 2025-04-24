class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>();
        int answer = 0;

        for (int num : nums) {
            distinctNums.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> tmpSet = new HashSet<>();
            
            for (int j = i; j < nums.length; j++) {
                tmpSet.add(nums[j]);

                if (tmpSet.size() == distinctNums.size()) {
                    answer += nums.length - j;
                    break;
                }
            }
        }

        return answer;
    }
}