import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> lru = new LinkedList<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (!lru.contains(city)) { // cache miss
                if (lru.size() == cacheSize) {
                    lru.pollFirst();
                }
                
                if (cacheSize != 0) {
                    lru.add(city);
                }

                answer += 5;
            }
            
            else { // cache hit
                lru.remove(city);
                lru.add(city);
                
                answer += 1;
            }
        }
        
        return answer;
    }
}