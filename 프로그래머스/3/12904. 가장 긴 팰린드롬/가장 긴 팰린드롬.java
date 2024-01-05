import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s, j, j + i - 1)) return i;
            }
        }

        return 0;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start += 1;
            end -= 1;
        }
        
        return true;
    }
}