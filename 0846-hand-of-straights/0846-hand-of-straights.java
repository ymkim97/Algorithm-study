class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(hand);

        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) continue;

            for (int j = 1; j < groupSize; j++) {

                int next = map.getOrDefault(hand[i] + j, 0);

                if (next == 0) {
                    System.out.println(i);
                    return false;
                }

                map.put(hand[i] + j, next - 1);
            }

            map.put(hand[i], map.get(hand[i]) - 1);
        }

        return true;
    }
}