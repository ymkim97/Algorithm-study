class Solution {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }

        int left = a[0];
        int right = a[a.length - 1];
        int ans = 2;

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < left) {
                left = a[i];
                ans++;
            }

            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];
                ans++;
            }
            
            if (left == right) {
                ans--;
                break;
            }
        }
        return ans;
    }
}