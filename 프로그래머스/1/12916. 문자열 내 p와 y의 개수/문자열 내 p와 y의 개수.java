class Solution {
    boolean solution(String s) {

        int y = 0;
        int p = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                y++;
            else if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
                p++;
        }
        
        if (y == p)
            return true;
        else
            return false;
    }
}