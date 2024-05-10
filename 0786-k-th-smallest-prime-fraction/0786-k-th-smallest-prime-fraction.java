class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Point> lst = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];

                Point p = new Point(a, b);
                p.res = (double)a / b;
                lst.add(p);
            }
        }

        Collections.sort(lst, (a, b) -> Double.compare(a.res, b.res));
        int[] answer = new int[2];

        answer[0] = lst.get(k - 1).a;
        answer[1] = lst.get(k - 1).b;

        return answer;
    }

    static class Point {
        int a;
        int b;
        double res;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}