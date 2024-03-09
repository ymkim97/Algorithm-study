class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int aPointer = 0;
        int bPointer = 0;

        while (aPointer < nums1.length && bPointer < nums2.length) {
            if (nums1[aPointer] == nums2[bPointer]) {
                return nums1[aPointer];
            }

            if (nums1[aPointer] > nums2[bPointer]) {
                bPointer += 1;
            }

            else {
                aPointer += 1;
            }
        }

        return -1;
    }
}