class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            sums.add(tmp);

            for (int j = i + 1; j < nums.length; j++) {
                tmp += nums[j];
                sums.add(tmp);
            }
        }

        Collections.sort(sums);

        int answer = 0;

        for (int i = left - 1; i <= right - 1; i++) {
            answer = (answer + sums.get(i)) % (int)(Math.pow(10, 9) + 7);
        }

        return answer;
    }
}