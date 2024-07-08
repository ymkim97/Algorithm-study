class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            int cnt = 1;

            while (cnt != k) {
                q.offer(q.poll());
                cnt += 1;
            }

            q.poll();
        }

        return q.poll();
    }
}