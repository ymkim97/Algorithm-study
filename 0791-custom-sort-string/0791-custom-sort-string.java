class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        int idx = 0;
        for (char c : order.toCharArray()) {
            map.put(c, idx);
            idx += 1;
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> indexes = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                indexes.add(map.get(c));
            }

            else {
                sb.append(c);
            }
        }

        Collections.sort(indexes);

        for (int i : indexes) {
            sb.append(order.charAt(i));
        }

        return sb.toString();
    }
}