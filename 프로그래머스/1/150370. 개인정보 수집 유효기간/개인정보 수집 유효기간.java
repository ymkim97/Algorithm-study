import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        String[] splt = today.split("\\.");
        int todayInt = Integer.parseInt(splt[0]) * 28 * 12 + Integer.parseInt(splt[1]) * 28 + Integer.parseInt(splt[2]);
        
        Map<String, Integer> term = new HashMap<>();
        
        for (String t : terms) {
            String[] s = t.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }
        
        int number = 1;
        
        for (String privacy : privacies) {
            String[] s1 = privacy.split(" ");
            String[] s2 = s1[0].split("\\.");
            
            String termForP = s1[1];
            int dayInt = Integer.parseInt(s2[0]) * 28 * 12 + Integer.parseInt(s2[1]) * 28 + Integer.parseInt(s2[2]);

            dayInt += term.get(termForP) * 28;
            
            if (dayInt <= todayInt) answer.add(number);
            
            number += 1; 
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}