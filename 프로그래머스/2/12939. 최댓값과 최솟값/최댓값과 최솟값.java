import java.util.*;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        List<Integer> lst = new ArrayList<>();
        
        for (String n: nums) {
            lst.add(Integer.valueOf(n));
        }
        
        Collections.sort(lst);
        
        StringBuilder sb = new StringBuilder();
        sb.append(lst.get(0)).append(" ");
        sb.append(lst.get(lst.size() - 1));
        
        return sb.toString();
    }
}