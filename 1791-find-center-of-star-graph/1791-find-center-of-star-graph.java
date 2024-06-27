class Solution {
    public int findCenter(int[][] edges) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < edges.length; i++) {
            if (i == 0) {
                a = edges[i][0];
                b = edges[i][1];
            }

            else {
                if (a == edges[i][0] || a == edges[i][1]) return a;
                else return b;
            }
        }

        return a;
    }
}