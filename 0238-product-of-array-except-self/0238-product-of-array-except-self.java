class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] products = new int[length];

        int prefix = 1;
        for (int i = 0; i < length; i++) {
            products[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = length - 1; i >= 0; i--) {
            products[i] *= suffix;
            suffix *= nums[i];
        }

        return products;
    }
}