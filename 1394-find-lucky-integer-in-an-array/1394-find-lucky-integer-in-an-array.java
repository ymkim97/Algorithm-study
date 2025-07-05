class Solution {
    public int findLucky(int[] arr) {
        int[] numsCount = new int[501];

        for (int n : arr) {
            numsCount[n] += 1;
        }

        int answer = -1;

        for (int i = 500; i > 0; i--) {
            if (numsCount[i] == i) {
                return i;
            }
        }

        return answer;
    }
}