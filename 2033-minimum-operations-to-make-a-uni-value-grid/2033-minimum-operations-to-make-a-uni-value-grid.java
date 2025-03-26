class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nums.add(grid[i][j]);
            }
        }

        Collections.sort(nums);
        int n = nums.size();

        for (int number : nums) {
            if (number % x != nums.get(n / 2) % x) return -1;

            answer += Math.abs(nums.get(n / 2) - number) / x;
        }

        return answer;
    }
}