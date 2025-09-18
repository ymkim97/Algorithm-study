import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String kConverted = convert(n, k);
        
        String[] splt = kConverted.split("0");
        
        for (String s : splt) {
            if (!s.isBlank() && isPrime(s)) answer += 1;
        }
        
        return answer;
    }
    
    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    private boolean isPrime(String s) {
        long n = Long.valueOf(s);
        
        if (n <= 1) return false;
        
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}