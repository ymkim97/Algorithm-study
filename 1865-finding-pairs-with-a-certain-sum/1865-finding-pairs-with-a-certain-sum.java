class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> cnt;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();
        for (int n : nums2) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        cnt.put(oldVal, cnt.get(oldVal) - 1);
        nums2[index] += val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int res = 0;
        for (int num : nums1) {
            int rest = tot - num;
            res += cnt.getOrDefault(rest, 0);
        }

        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */