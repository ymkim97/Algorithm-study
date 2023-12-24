import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(B);
        Arrays.sort(A);
        
        int idxA = 0;
        int idxB = 0;
        
        while (idxB < B.length) {
            
            if (B[idxB] > A[idxA]) { // B가 이김
                answer += 1;
                idxB += 1;
                idxA += 1;
            }
            
            else {
                idxB += 1;
            }
        }
        
        return answer;
    }
}