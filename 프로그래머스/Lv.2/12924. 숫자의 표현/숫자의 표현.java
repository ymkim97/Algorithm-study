class Solution {
    public int solution(int n) {
        int answer = 0;
        int right = 1;
        int left = 1;
        int sum = 1;
        
        while (left <= n || right <= n) {
            
            if (sum < n) {
                right += 1;
                sum += right;
            }
            
            else if (sum > n) {
                sum -= left;
                left += 1;
            }
            
            else if (sum == n) {
                answer += 1;
                sum -= left;
                left += 1;
            }
        }
        
        return answer;
    }
}