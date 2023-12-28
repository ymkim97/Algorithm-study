class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = Integer.MAX_VALUE;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (check(stones, k, mid)) {
                System.out.println(mid);
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
            
            else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] stones, int k, int mid) {
        int unavail = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                unavail += 1;
            }
            
            else {
                unavail = 0;
            }
            
            if (unavail == k) {
                return false;
            }
            
        }
        
        return true;
    }
}