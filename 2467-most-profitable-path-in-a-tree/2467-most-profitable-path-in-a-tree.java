class Solution {

    int answer;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        answer = Integer.MIN_VALUE;
        int n = amount.length;
        List<Integer>[] lst = new ArrayList[n];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (lst[a] == null) lst[a] = new ArrayList<>();
            if (lst[b] == null) lst[b] = new ArrayList<>();

            lst[a].add(b);
            lst[b].add(a);
        }

        // Bob move
        amount[bob] = 0;
        List<Integer> moved = new ArrayList<>();

        findBobPath(bob, -1, moved, lst);

        if (moved.size() % 2 == 0) { // 움직인 횟수가 짝수일때 -> 만남
            int meetIdx = moved.size() / 2 - 1;

            for (int i = 0; i < moved.size() / 2; i++) {
                if (i == meetIdx) amount[moved.get(meetIdx)] /= 2;
                else amount[moved.get(i)] = 0;
            }
        } else { // 움직인 횟수가 홀수일때 -> 만남 X
            for (int i = 0; i < moved.size() / 2; i++) {
                amount[moved.get(i)] = 0;
            }
        }

        // Alice move
        dfs(0, -1, lst, amount, amount[0]);

        return answer;
    }

    public boolean findBobPath(int x, int parentNode, List<Integer> moved, List<Integer>[] lst) {
        if (x == 0) return true;

        for (int next : lst[x]) {
            if (next != parentNode) {
                moved.add(next);
                if (findBobPath(next, x, moved, lst)) return true;
                moved.remove(moved.size() - 1);
            }
        }

        return false;
    }

    public void dfs(int x, int parentNode, List<Integer>[] lst, int[] amount, int sum) {
        boolean isLeaf = true;

        for (int next : lst[x]) {
            if (next != parentNode) {
                isLeaf = false;
                dfs(next, x, lst, amount, sum + amount[next]);
            }
        }

        if (isLeaf) {
            answer = Math.max(answer, sum);
        }
    }
}