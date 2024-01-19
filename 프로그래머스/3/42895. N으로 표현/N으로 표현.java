import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> count = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            count.add(new HashSet<>());
        }
        
        count.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            Set<Integer> eachSet = count.get(i);
            eachSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                
                for (int num1 : count.get(j)) {
                    for (int num2 : count.get(k)) {
                        eachSet.add(num1 + num2);
                        eachSet.add(num1 - num2);
                        eachSet.add(num1 * num2);
                        if (num2 != 0) {
                            eachSet.add(num1 / num2);
                        }
                    }
                }
            }
            
            if (eachSet.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}