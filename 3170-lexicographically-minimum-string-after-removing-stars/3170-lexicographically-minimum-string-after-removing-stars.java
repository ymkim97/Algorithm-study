class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { //0: idx, 1: char
            if (a[1] == b[1]) return b[0] - a[0];

            return a[1] - b[1];
        });

        Set<Integer> toDel = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                pq.offer(new int[] {i, s.charAt(i) - 'a'});
            } else {
                toDel.add(i);
                toDel.add(pq.poll()[0]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!toDel.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}