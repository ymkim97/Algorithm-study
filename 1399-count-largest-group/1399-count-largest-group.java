class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int largestSize = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            int num = i;

            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            largestSize = Math.max(largestSize, map.get(tmp));
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        int answer = 0;
        for (int key : keys) {
            if (map.get(key) == largestSize) answer += 1;
        }

        return answer;
    }
}