import java.util.*;

class Solution {
    Map<String, Integer> permu = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (String order : orders) {
            for (int length : course) {
                if (order.length() < length) continue;
                
                getPermus(order, length, -1, "");
            }
        }

        List<String> keys = new ArrayList<>(permu.keySet());
        Collections.sort(keys, (a, b) -> permu.get(b) - permu.get(a));
        int[] maxLengths = new int[11];
        
        for (String key : keys) {
            if (permu.get(key) >= maxLengths[key.length()]) {
                maxLengths[key.length()] = permu.get(key);
                
                if (permu.get(key) >= 2) {
                    answer.add(key);
                }
            }
        }
    
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public void getPermus(String order, int targetLength, int idx, String comb) {
        if (comb.length() == targetLength) {
            char[] tmp = comb.toCharArray();
            Arrays.sort(tmp);
            comb = String.valueOf(tmp);
            permu.put(comb, permu.getOrDefault(comb, 0) + 1);
            return;
        }
        
        for (int i = idx + 1; i < order.length(); i++) {
            getPermus(order, targetLength, i, comb + order.charAt(i));
        }
    }

}