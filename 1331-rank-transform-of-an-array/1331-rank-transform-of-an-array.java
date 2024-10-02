class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Queue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int a: arr) {
            pq.offer(a);
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            int num = pq.poll();

            if (map.containsKey(num)) continue;

            map.put(num, rank);

            rank += 1;
        }

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}