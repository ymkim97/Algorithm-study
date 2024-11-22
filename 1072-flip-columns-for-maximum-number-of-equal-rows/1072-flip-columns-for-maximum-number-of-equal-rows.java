class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] m : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int t : m) {
                sb1.append(t);
                sb2.append(1 - t);
            }

            String str1 = sb1.toString();
            String str2 = sb2.toString();
            
            map.put(str1, map.getOrDefault(str1,0) + 1);
            map.put(str2, map.getOrDefault(str2,0) + 1);
        }

        int answer = 0;

        for (int v : map.values()) {
            answer = Math.max(answer, v);
        }

        return answer;
    }
}