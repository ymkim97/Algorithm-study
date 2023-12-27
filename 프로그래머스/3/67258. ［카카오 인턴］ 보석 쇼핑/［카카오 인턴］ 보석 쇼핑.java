import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int answer1 = 0;
        int answer2 = 0;
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        
        Set<String> temp = new HashSet();
        Map<String, Integer> tempCnt = new HashMap<>();
        for (String gem : gems) {
            if (!tempCnt.containsKey(gem)) {
                tempCnt.put(gem, 0);
            }
        }
        
        temp.add(gems[0]);
        tempCnt.put(gems[0], 1);
        int left = 0;
        int right = 0;
        
       while (right < gems.length) {
           
           if (temp.size() == kind) {
               if ((answer1 == 0 && answer2 == 0 && left == 0) || (Math.abs(right - left) < answer2 - answer1)) {
                   answer1 = left;
                   answer2 = right;
               }
  
               String leftStr = gems[left];
               left += 1;
               if (left >= gems.length || left > right) {
                   break;
               }
               
               tempCnt.put(gems[left - 1], tempCnt.get(gems[left - 1]) - 1);
               if (tempCnt.get(gems[left - 1]) == 0) {
                   temp.remove(leftStr);
               }
               
               continue;
           }
           
           right += 1;
           if (right < gems.length) {
               temp.add(gems[right]);
               tempCnt.put(gems[right], tempCnt.get(gems[right]) + 1);
           }
       }
        
        return new int[] {answer1 + 1, answer2 + 1};
    }
}