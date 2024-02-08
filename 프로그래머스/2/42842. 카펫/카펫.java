class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int i = 1; i <= brown; i++) { // 가로
            for (int j = 1; j <= i; j++) { // 세로
                if ((i * j == total) && ((i + j) * 2 - 4) == brown) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {};
    }
}