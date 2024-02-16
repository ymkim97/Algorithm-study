import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> str1Lst = new ArrayList<>();
        List<String> str2Lst = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                str1Lst.add(str1.substring(i, i + 2));
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
                str2Lst.add(str2.substring(i, i + 2));
            }
        }
        
        if (str1Lst.isEmpty() && str2Lst.isEmpty()) {
            return 65536;
        }
        
        List<String> cp2 = new ArrayList<>(str2Lst);
        List<String> and = new ArrayList<>();

        for (String s : str1Lst) {
            if (cp2.contains(s)) {
                and.add(s);
                cp2.remove(s);
            }
        }
        
        List<String> all = new ArrayList<>();
        all.addAll(str1Lst);
        all.addAll(str2Lst);
        
        for (String s : and) {
            all.remove(s);
        }
        
        double answer = (double)and.size() / all.size();

        return (int) (answer * 65536);
    }
}