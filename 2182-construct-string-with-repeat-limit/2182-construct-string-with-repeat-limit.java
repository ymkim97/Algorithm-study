class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        for (int i = 0; i < keys.size(); i++) {
            char key = keys.get(i);
            if (map.get(key) == 0) continue;

            int avail = map.get(key);

            if (avail <= repeatLimit) {
                for (int j = 0; j < avail; j++) {
                    sb.append(key);
                }

                continue;
            }

            for (int j = 0; j < repeatLimit; j++) {
                sb.append(key);
            }

            map.put(key, avail - repeatLimit);

            if (i == keys.size() - 1) break;

            int nextIdx = i + 1;

            while (nextIdx != keys.size() && map.get(keys.get(nextIdx)) == 0) {
                nextIdx += 1;
            }

            if (nextIdx == keys.size()) break;

            char nextKey = keys.get(nextIdx);
            int nextAvail = map.get(nextKey);
            sb.append(nextKey);

            map.put(nextKey, nextAvail - 1);
            i -= 1;
        }

        return sb.toString();
    }
}
