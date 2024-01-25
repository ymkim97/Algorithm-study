import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportTo = new HashMap<>();
        
        for (String report : reports) {
            String[] lst = report.split(" ");
            String from = lst[0];
            String to = lst[1];
            
            Set<String> tmp = reportTo.getOrDefault(from, new HashSet<>()); // 각자 누구를 리폿했는지 
            if (!tmp.contains(to)) {
                reportCount.put(to, reportCount.getOrDefault(to, 0) + 1); // 각자 리폿을 받는 횟수 count
                tmp.add(to);
                reportTo.put(from, tmp);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            Set<String> reported = reportTo.getOrDefault(id_list[i], new HashSet<>());
            
            for (String eachReport : reported) {
                if (reportCount.get(eachReport) >= k) {
                    cnt += 1;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}