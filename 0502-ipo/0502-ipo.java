class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> capPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<int[]> proPq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < profits.length; i++) {
            capPq.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!capPq.isEmpty() && capPq.peek()[0] <= w) {
                proPq.add(capPq.poll());
            }

            if (proPq.isEmpty()) break;

            w += proPq.poll()[1];
        }

        return w;
    }
}