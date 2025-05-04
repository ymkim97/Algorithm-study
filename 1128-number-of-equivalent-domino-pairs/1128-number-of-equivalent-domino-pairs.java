class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Domino, Integer> map = new HashMap<>();

        for (int[] dominoe : dominoes) {
            int a = Math.min(dominoe[0], dominoe[1]);
            int b = Math.max(dominoe[0], dominoe[1]);

            Domino domino = new Domino(a, b);

            if (!map.containsKey(domino)) map.put(domino, 0);

            map.put(domino, map.get(domino) + 1);
        }

        List<Domino> keys = new ArrayList<>(map.keySet());

        int answer = 0;

        for (Domino key : keys) {
            int n = map.get(key);

            answer += (n * (n - 1)) / 2;
        }

        return answer;
    }

    static class Domino {
        int a;
        int b;

        public Domino(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            Domino d = (Domino)o;

            if (this.a == d.a && this.b == d.b) return true;

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }
    }
}