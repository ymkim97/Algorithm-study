class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int answer = 0;
        Arrays.sort(tokens);
        Deque<Integer> newTokens = new ArrayDeque<>();

        for (int t : tokens) {
            newTokens.add(t);
        }

        while (!newTokens.isEmpty()) {
            if (power >= newTokens.peekFirst()) {
                power -= newTokens.pollFirst();
                answer += 1;
            }

            else {
                if (answer == 0 || (newTokens.size() == 1 && newTokens.peekLast() > power)) break;

                power += newTokens.pollLast();
                answer -= 1;
            }
        }

        return answer;
    }
}