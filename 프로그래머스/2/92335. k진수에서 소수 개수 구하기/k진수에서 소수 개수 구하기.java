import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] binLst = makeBinLst(n, k);
        
        for (String bin : binLst) {
            if (bin.equals("")) continue;
            
            if (isPrime(Long.parseLong(bin))) answer += 1;
        }
        
        return answer;
    }
    
    public String[] makeBinLst(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        
        return sb.toString().split("0");
    }
    
    public boolean isPrime(Long n) {
        if (n == 1) return false;
        
        for (long i = 2; i < (long)Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}