import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (!Character.isLetter(str1.charAt(i)) || !Character.isLetter(str1.charAt(i + 1))) continue;
            
            lst1.add(str1.substring(i, i + 2));
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (!Character.isLetter(str2.charAt(i)) || !Character.isLetter(str2.charAt(i + 1))) continue;
            
            lst2.add(str2.substring(i, i + 2));
        }
        
        if (lst1.isEmpty() && lst2.isEmpty()) {
            return 65536;
        }
        
        List<String> and = new ArrayList<>();
        List<String> cp2 = new ArrayList<>(lst2);
        
        for (String s : lst1) {
            if (cp2.contains(s)) {
                and.add(s);
                cp2.remove(s);
            }
        }
        
        List<String> all = new ArrayList<>();
        
        all.addAll(lst1);
        all.addAll(lst2);
        
        for (String s : and) {
            all.remove(s);
        }
        
        return (int) ((double)and.size() / all.size() * 65536);
    }
}