class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveCnt = 0;

        for (int n : arr) {
            if (n % 2 != 0) consecutiveCnt += 1;
            else consecutiveCnt = 0;

            if (consecutiveCnt == 3) return true;
        }
        
        return false;
    }
}