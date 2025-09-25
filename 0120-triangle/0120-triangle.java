class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                int tmp = triangle.get(i - 1).get(j);
                List<Integer> line = triangle.get(i - 1);
                line.set(j, Math.min(tmp + triangle.get(i).get(j), tmp + triangle.get(i).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}