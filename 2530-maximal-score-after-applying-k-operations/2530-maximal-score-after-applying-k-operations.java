class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) {
            q.offer(n);
        }

        long answer = 0;

        for (int i = 0; i < k; i++) {
            int t = q.poll();

            answer += t;

            System.out.println((int)((t / 3) + 0.5));
            q.offer(t % 3 == 0 ? t / 3 : t / 3 + 1);
        }

        return answer;
    }
}