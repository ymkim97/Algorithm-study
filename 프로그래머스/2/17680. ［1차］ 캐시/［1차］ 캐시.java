import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        ArrayDeque<String> ad = new ArrayDeque<>();
        
        for (String city: cities) {
            city = city.toLowerCase();
            
            if (ad.contains(city)) {
                answer += 1;
                ad.remove(city);
                ad.addLast(city); 
            } else {
                answer += 5;
                
                if (cacheSize == 0) continue;
                
                if (ad.size() == cacheSize) ad.pollFirst();
          
                ad.addLast(city);
            }
        }
        
        return answer;
    }
}