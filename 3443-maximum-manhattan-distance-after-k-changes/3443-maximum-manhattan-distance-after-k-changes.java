class Solution {
    public int maxDistance(String s, int k) {
        int answer = 0;
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'N') north += 1;
            else if (c == 'S') south += 1;
            else if (c == 'E') east += 1;
            else west += 1;

            int x = Math.abs(north - south);
            int y = Math.abs(east - west);
            int md = x + y;

            int dist = md + Math.min(2 * k, i + 1 - md);
            answer = Math.max(answer, dist);
        }

        return answer;
    }
}