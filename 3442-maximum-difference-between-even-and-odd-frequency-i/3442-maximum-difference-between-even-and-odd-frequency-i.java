class Solution {
    public int maxDifference(String s) {
        int maxOdd = 0;
        int minEven = 101;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());

        for (char key : keys) {
            int cnt = map.get(key);

            if (cnt % 2 == 0 && cnt < minEven) {
                minEven = cnt;
            } else if (cnt % 2 != 0 && cnt > maxOdd) {
                maxOdd = cnt;
            }
        }

        return maxOdd - minEven;
    }
}