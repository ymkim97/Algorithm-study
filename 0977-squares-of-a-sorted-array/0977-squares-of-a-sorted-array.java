class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int n : nums) {
            answer.add(n * n);
        }

        Collections.sort(answer);
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}