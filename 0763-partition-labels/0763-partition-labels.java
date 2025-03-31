class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        List<Character> keys = new ArrayList<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            keys.add(c);
            count.put(c, count.get(c) - 1);

            boolean possible = true;
            for (char key : keys) {
                if (count.get(key) != 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer.add(keys.size());
                keys.clear();
            }
        }

        return answer;
    }
}