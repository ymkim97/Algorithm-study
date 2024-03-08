class Solution {
    long[] tile = new long[5001];
    
    public long solution(int n) {
        long answer = 0;
  
        tile[0] = 1;
        tile[2] = 3;
        
       for(int i = 4; i <= n; i += 2){
            tile[i] = tile[i - 2] * 3;
           
            for(int j = i - 4; j >= 0; j -= 2){
                tile[i] += tile[j] * 2;
            }
           
            tile[i] = tile[i] % 1000000007;
        }
        
        return answer = tile[n];
    }
    
  
}