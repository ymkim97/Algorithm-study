class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int N = n;
        Map<Integer, Long> count = new HashMap<>();
        List<Integer>[] map = new ArrayList[n];

        for (int[] road : roads) {
            count.put(road[0], count.getOrDefault(road[0], 0L) + 1);
            count.put(road[1], count.getOrDefault(road[1], 0L) + 1);

            if (map[road[0]] == null) map[road[0]] = new ArrayList<>();
            if (map[road[1]] == null) map[road[1]] = new ArrayList<>();

            map[road[0]].add(road[1]);
            map[road[1]].add(road[0]);
        }

        List<Integer> keys = new ArrayList<>(count.keySet());

        Collections.sort(keys, (a, b) -> Long.compare(count.get(b), count.get(a)));

        Map<Integer, Long> mapper = new HashMap<>();

        for (int key : keys) {
            mapper.put(key, n + 0L);
            n -= 1;
        }

        long answer = 0;
        
        for (int key : keys) {
            answer += map[key].size() * mapper.get(key);
        }

        return answer;
    }
}