import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        
        String[] spl = s.split("\\}\\,\\{");
        
        Arrays.sort(spl, (a, b) -> a.length() - b.length());
        
        for (String each : spl) {
            String[] numbers = each.split(",");
            
            for (String number : numbers) {
                int n = Integer.parseInt(number);
                if (!answer.contains(n)) {
                    answer.add(n);
                }
            }
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}