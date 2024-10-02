class Solution {
    public int solution(int[] citations) {
        int start = 0;
        int end = citations.length;
        int answer = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) cnt += 1;
            }
            
            if (cnt >= mid) {
                answer = mid;
                start = mid + 1;
            } else end = mid - 1;
            
        }
        
        return start - 1;
    }
}