class Solution {
    
    public void sortColors(int[] nums) {
        int zeroPointer = -1;
        ArrayList<Integer> lst = new ArrayList<>();

        for (int n : nums) {
            if (n == 0) {
                lst.add(0, n);
                zeroPointer += 1;
            }

            else if (n == 2) lst.add(n);

            else {
                if (lst.isEmpty()) lst.add(n);
                else if (lst.get(lst.size() - 1) == 0 || lst.get(lst.size() - 1) == 1) lst.add(n);
                else if (zeroPointer == -1) lst.add(0, n);
                else lst.add(zeroPointer + 1, n);
            }
        }

        for (int i = 0; i < lst.size(); i++) {
            nums[i] = lst.get(i);
        }
    }
}