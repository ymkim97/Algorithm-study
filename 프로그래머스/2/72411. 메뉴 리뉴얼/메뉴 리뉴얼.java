import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int c : course) {
            HashMap<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < orders.length; i++) {
                char[] str = orders[i].toCharArray();
                Arrays.sort(str);
                
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < str.length; j++) {
                    sb.append(str[j]);
                }
                
                dfs(0, c, sb.toString(), map, new StringBuilder());
            }
            
            List<String> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));
            
            if (keys.isEmpty() || map.get(keys.get(0)) < 2) continue;
            
            int maxCnt = map.get(keys.get(0));
            int idx = 0;
            
            while (idx < keys.size() && map.get(keys.get(idx)) == maxCnt) {
                answer.add(keys.get(idx));
                idx += 1;
            }
            
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(int start, int length, String order, HashMap<String, Integer> map, StringBuilder sb) {
        if (length == sb.length()) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(i + 1, length, order, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}