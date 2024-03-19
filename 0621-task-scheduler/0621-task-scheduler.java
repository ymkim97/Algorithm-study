class Solution {
    public int leastInterval(char[] tasks, int n) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while(!map.isEmpty()) {
            int tmpCnt = 0;

            List<Character> keys = new ArrayList(map.keySet());
            Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));

            for (char key : keys) {
                tmpCnt += 1;
                int amount = map.get(key);
                if (amount == 1) {
                    map.remove(key);
                }
                
                else{
                    map.put(key, amount - 1);
                }

                if (tmpCnt == n + 1) break;
            }

            if (tmpCnt < n + 1) {
                if (map.isEmpty()) {
                    answer += tmpCnt;
                }

                else {
                    answer += n + 1;
                }
            }

            else {
                answer += tmpCnt;
            }
        }

        return answer;
    }
}