class Solution {
    public int pivotInteger(int n) {
        int answer = -1;
        int sum = (n * (n + 1)) / 2;
        int tmp = 0;

        for (int i = 1; i <= n; i++) {
            sum -= i;
            if (tmp == sum) {
                return i;
            }
            tmp += i;
        }

        return answer;
    }
}