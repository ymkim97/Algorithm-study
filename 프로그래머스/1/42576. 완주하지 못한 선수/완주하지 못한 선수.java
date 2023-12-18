import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        
        for (String p : participant) {
            if (!participants.containsKey(p)) {
                participants.put(p, 1);
            } else {
                int value = participants.get(p);
                participants.put(p, ++value);
            }
        }
        
        for (String c : completion) {
            int value = participants.get(c);
            participants.put(c, --value);
        }
        
        for (String key : participants.keySet()) {
            if (participants.get(key) == 1) {
                return key;
            }
        }
        return "";
    }
}