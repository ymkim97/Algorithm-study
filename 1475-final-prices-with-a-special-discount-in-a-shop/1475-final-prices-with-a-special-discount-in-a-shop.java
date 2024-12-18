class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = prices[i];
            int discount = 0;

            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }

            answer[i] = cur - discount;
        }

        return answer;
    }
}