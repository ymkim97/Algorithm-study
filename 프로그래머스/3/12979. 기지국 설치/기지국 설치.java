class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        
        for (int station : stations) {
            int notCovered = station - w - 1;
            
            if (notCovered >= start) {
                int length = notCovered - start + 1;
                answer += (int)Math.ceil((double)length / (2 * w + 1));           
            }
            start = station + w + 1;
        }
        
        if (start <= n) {
            int length = n - start + 1;
            answer += (int)Math.ceil((double)length / (2 * w + 1));   
        }

        return answer;
    }
}