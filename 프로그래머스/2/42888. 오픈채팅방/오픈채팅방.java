import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        
        for (String record : records) {
            String[] r = record.split(" ");
            
            if (r[0].equals("Leave")) continue;
            
            users.put(r[1], r[2]);
        }
        
        for (String record: records) {
            String[] r = record.split(" ");
            
            if (r[0].equals("Enter")) {
                String announcement = users.get(r[1]) + "님이 들어왔습니다.";
                answer.add(announcement);
            }
            
            else if (r[0].equals("Leave")) {
                String announcement = users.get(r[1]) + "님이 나갔습니다.";
                answer.add(announcement);
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}