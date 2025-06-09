class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, answer);
        }

        return answer;
    }

    private void dfs(int cur, int limit, List<Integer> answer) {
        if (cur > limit) return;

        answer.add(cur);

        for (int i = 0; i <= 9; i++) {
            int nextNum = cur * 10 + i;

            if (nextNum <= limit) {
                dfs(nextNum, limit, answer);
            } else {
                break;
            }
        }
    }
}