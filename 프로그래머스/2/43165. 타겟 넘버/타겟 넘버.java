class Solution {
    
    int answer = 0;
    int target;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) answer += 1;
            
            return;
        }
        
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }
}