class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> map.get(a) - map.get(b));

        int removed = 0;
        for (int key : keys) {
            int cnt = map.get(key);
            
            if (removed == k) {
                answer += 1;
            }

            else if (removed < k && removed + cnt > k) {
                answer += 1;
                removed = k;
            }

            else {
                removed += cnt;
            }

        }

        return answer;
    }
}