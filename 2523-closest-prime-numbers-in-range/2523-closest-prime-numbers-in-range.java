class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[1] = false;

        for (int i = 2; i <= right; i++) {
            if (!isPrime[i]) continue;

            for (int j = 2; i * j <= right; j++) {
                isPrime[i * j] = false;
            }
        }

        List<Integer> lst = new ArrayList<>();
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;

        for (int num = left; num <= right; num++) {
            if (isPrime[num]) lst.add(num);
        }
    
        if (lst.size() <= 1) return answer;

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < lst.size() -1 ; i++) {
            System.out.println(lst.get(i));
            int diff = lst.get(i + 1) - lst.get(i);

            if (diff < minDiff) {
                minDiff = diff;
                answer[0] = lst.get(i);
                answer[1] = lst.get(i + 1);
            }
        }

        return answer;
    }
}