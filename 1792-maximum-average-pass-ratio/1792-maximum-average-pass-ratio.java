class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(
            ((double)(a[0] + 1) / (a[1] + 1)) - ((double)(a[0]) / (a[1])),  ((double)(b[0] + 1) / (b[1] + 1)) - ((double)(b[0]) / (b[1]))
        );

        for (int[] clazz : classes) {
            pq.offer(clazz);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] now = pq.poll();
            now[0] += 1;
            now[1] += 1;
            pq.offer(now);
        }

        double answer = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            System.out.println(now[0]);
            System.out.println(now[1]);

            System.out.println();
            answer += (double)now[0] / now[1];
        }

        return answer / classes.length;
    }
}

// [2,3] [3,5] [2,2]
// 0.666  0.6    1