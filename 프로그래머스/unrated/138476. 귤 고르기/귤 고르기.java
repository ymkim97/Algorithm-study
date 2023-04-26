import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> group = new HashMap<>();
        
        for(int each: tangerine) {
            if(group.containsKey(each)) {
                group.put(each, group.get(each) + 1);
            }
            else {
                group.put(each, 1);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(group.keySet());
        keySet.sort((o1, o2) -> {return group.get(o2) - group.get(o1);});
        
        for(int key: keySet) {
            cnt += group.get(key);
            answer += 1;
            if(cnt >= k) {
                break;
            }
        }
        
        return answer;
    }
}