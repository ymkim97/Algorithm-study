import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportedCount = new HashMap<>();
        Map<String, Integer> notifyCount = new HashMap<>();
        
        for (String id : id_list) {
            reportedCount.put(id, new HashSet<>());
        }
        
        for (String r : report) {
            String[] splt = r.split(" ");
            String reporter = splt[0];
            String reported = splt[1];
            
            Set<String> reporters = reportedCount.get(reported);
            reporters.add(reporter);
        }
        
        for (String reportedCountKey : reportedCount.keySet()) {
            if (reportedCount.get(reportedCountKey).size() >= k) {
                for (String reporter : reportedCount.get(reportedCountKey)) {
                    notifyCount.put(reporter, notifyCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = notifyCount.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}