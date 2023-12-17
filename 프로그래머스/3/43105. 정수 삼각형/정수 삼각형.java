class Solution {
    public int solution(int[][] triangle) {
        
        for (int i = triangle.length - 1; i > 0; i--) {
            
            for (int j = 0; j <= triangle[i].length - 2; j++) {
                int lastNum = triangle[i - 1][j];
                triangle[i - 1][j] = Math.max(lastNum + triangle[i][j], lastNum + triangle[i][j + 1]);
            }
        }
        
        return triangle[0][0];
    }
}