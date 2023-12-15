import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] befChar = before.toCharArray();
        char[] afChar = after.toCharArray();
        
        Arrays.sort(befChar);
        Arrays.sort(afChar);
        
        String befStr = Arrays.toString(befChar);
        String afStr = Arrays.toString(afChar);
        
        System.out.println(befStr);
        System.out.println(afStr);
        
        return befStr.equals(afStr) ? 1 : 0;
    }
}