import java.util.*;

class Solution {
    public int[] solution(String s) {        
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] list = s.split("\\},\\{");
        
        for (int i = 0; i < list.length; i++) {
            String changed = list[i].replace("{", "");
            changed = list[i].replace("}", "");
            
            list[i] = changed;
        }
        
        Arrays.sort(list, (a, b) -> a.length() - b.length());
        
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        
        for (String each: list) {
            String[] splt = each.split(",");
            
            for (String num: splt) {
                if (!answer.contains(Integer.parseInt(num))) {
                    answer.add(Integer.parseInt(num));
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}
