class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int right = 1;
        int sum = 1;
        
        while (left <= right && right <= n) {
            if (sum <= n) {
                if (sum == n) answer += 1;
                right += 1;
                sum += right;
            }
            else if (sum > n) {
                sum -= left;
                left += 1;
            }       
        }
        
        return answer;
    }
}