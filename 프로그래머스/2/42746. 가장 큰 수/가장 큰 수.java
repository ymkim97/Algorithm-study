import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> lst = new ArrayList<>();
        
        for (int n : numbers) {
            lst.add(String.valueOf(n));
        }
        
        Collections.sort(lst, (a, b) -> Integer.parseInt(b + a) - Integer.parseInt(a + b));
        
        if (lst.get(0).equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : lst) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}