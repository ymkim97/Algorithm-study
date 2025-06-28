class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];

            return b[1] - a[1];
        }); // 0: idx, 1: num

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {i, nums[i]});
        }

        List<int[]> sub = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            sub.add(pq.poll());
        }

        Collections.sort(sub, (a, b) -> a[0] - b[0]);

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = sub.get(i)[1];
        }

        return answer;
    }
}