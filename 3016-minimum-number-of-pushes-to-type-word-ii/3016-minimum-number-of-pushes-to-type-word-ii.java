class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));

        int answer = 0;
        for (int i = 0; i < keys.size(); i++) {
            answer += (map.get(keys.get(i))) * (i / 8 + 1);
        }

        return answer;
    }
}