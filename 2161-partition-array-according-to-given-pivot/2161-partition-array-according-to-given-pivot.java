class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int pivNumCnt = 0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num == pivot) pivNumCnt += 1;
            else if (num < pivot) left.add(num);
            else right.add(num);
        }

        for (int i = 0; i < pivNumCnt; i++) {
            left.add(pivot);
        }

        for (int r : right) {
            left.add(r);
        }

        return left.stream().mapToInt(a -> a).toArray();
    }
}