class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            answer[i] = solve(spells[i], potions, success);
        }

        return answer;
    }

    private int solve(int spell, int[] potions, long success) {
        int left = -1;
        int right = potions.length;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (potions[mid] * (long)spell < success) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return potions.length - right;
    }
}
