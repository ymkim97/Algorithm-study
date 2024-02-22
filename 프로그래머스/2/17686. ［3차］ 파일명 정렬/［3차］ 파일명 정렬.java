import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String> answer = new ArrayList<>();
        List<File> toOrder = new ArrayList<>();
        
        for (String file : files) {
            int idx = 0;
            
            String head = "";
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                head += file.charAt(idx);
                idx += 1;
            }
            
            String number = "";
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                number += file.charAt(idx);
                idx += 1;
            }
            
            String tail = "";
            while (idx < file.length()) {
                tail += file.charAt(idx);
                idx += 1;
            }
            
            File newFile = new File(head, number, tail);
            
            toOrder.add(newFile);
        }
        
        Collections.sort(toOrder, (a, b) -> {
            if (!a.head.toLowerCase().equals(b.head.toLowerCase())) return a.head.toLowerCase().compareTo(b.head.toLowerCase());
            
            if (Integer.parseInt(a.number) != Integer.parseInt(b.number)) return Integer.parseInt(a.number) - Integer.parseInt(b.number);
            
            return 0;
        });
        
        for (File f : toOrder) {
            String s = f.head + f.number + f.tail;
            answer.add(s);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    static class File {
        String head;
        String number;
        String tail;
        
        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}