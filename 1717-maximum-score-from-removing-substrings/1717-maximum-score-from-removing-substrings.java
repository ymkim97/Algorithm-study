class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        ArrayDeque<Character> ad = new ArrayDeque<>();

        if (x > y) {
            // ab
            for (char c : s.toCharArray()) {
                if (!ad.isEmpty() && ad.peek() == 'a' && c == 'b') {
                    ad.pop();
                    score += x;
                } else {
                    ad.push(c);
                }
            }

            // ba
            while (!ad.isEmpty()) {
                char c = ad.pop();
                
                if (!ad.isEmpty() && ad.peek() == 'b' && c == 'a') {
                    ad.pop();
                    score += y;
                }
            }
        } else {
            // ba
            for (char c : s.toCharArray()) {
                if (!ad.isEmpty() && ad.peek() == 'b' && c == 'a') {
                    ad.pop();
                    score += y;
                } else {
                    ad.push(c);
                }
            }

            // ab
            while (!ad.isEmpty()) {
                char c = ad.pop();
                
                if (!ad.isEmpty() && ad.peek() == 'a' && c == 'b') {
                    ad.pop();
                    score += x;
                }
            }
        }

        return score;
    }
}
