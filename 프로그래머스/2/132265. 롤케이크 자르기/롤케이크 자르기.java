import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] fromLeft = new int[topping.length];
        int[] fromRight = new int[topping.length];
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            if (!set.contains(topping[i])) set.add(topping[i]);
            
            fromLeft[i] = set.size();
        }
        
        set = new HashSet<>();
        
        for (int i = topping.length - 1; i >= 0; i--) {
            if (!set.contains(topping[i])) set.add(topping[i]);
            
            fromRight[i] = set.size();
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            if (fromLeft[i] == fromRight[i + 1]) answer += 1;
        }
        
        return answer;
    }
}

// 1 2 2 3 3 4 4 4

// 4 4 4 4 3 3 2 1