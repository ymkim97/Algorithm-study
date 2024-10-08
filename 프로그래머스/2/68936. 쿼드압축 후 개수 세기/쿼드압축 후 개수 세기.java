class Solution {

    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void dfs(int[][] arr, int x, int y, int n){
        int zeros = 0;
        int ones = 0;
        
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] == 0) zeros += 1;
                else ones += 1;
            }
        }
        
        if (zeros != 0 && ones == 0) answer[0] += 1;
        else if (zeros == 0 && ones != 0) answer[1] += 1;
        else {
            if (n == 1) return;
            
            dfs(arr, x, y, n / 2);
            dfs(arr, x + n / 2, y, n / 2);
            dfs(arr, x, y + n / 2, n / 2);
            dfs(arr, x + n / 2, y + n / 2, n / 2);
        }
    }
}