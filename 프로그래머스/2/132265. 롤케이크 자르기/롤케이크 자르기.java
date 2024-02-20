import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> rightSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        Set<Integer> leftSet = new HashSet<>();

        for (int t : topping) {
            rightSet.add(t);
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            leftSet.add(t);
            rightMap.put(t, rightMap.get(t) - 1);
            
            if (rightMap.get(t) == 0) {
                rightSet.remove(t);
            }
            
            if (leftSet.size() == rightSet.size()) answer += 1;
        }
        
        return answer;
    }
}