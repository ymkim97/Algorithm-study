class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = 0;
        int answer = 0;
        int continousCount = 0;

        for (int n : nums) {
            if (n > maxNum) {
                maxNum = n;
                answer = 0;
                continousCount = 0;
                continousCount += 1;
            } else if (n == maxNum) {
                continousCount += 1;
            } else {
                answer = Math.max(answer, continousCount);
                continousCount = 0;
            }
        }

        answer = Math.max(answer, continousCount);

        return answer;
    }
}
