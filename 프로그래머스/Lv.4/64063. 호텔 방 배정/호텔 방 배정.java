import java.util.*;

class Solution {
    
    Map<Long, Long> rooms;
    
    public long[] solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        rooms = new HashMap<>();
        
       for (long number : room_number) {
           answer.add(search(number));
       }
        
        return answer.stream().mapToLong(a -> a).toArray();
    }
    
    public long search(long number) {
        if (!rooms.containsKey(number)) {
            rooms.put(number, number + 1);
            return number;
        }
        
        long newRoom = search(rooms.get(number));
        rooms.put(number, newRoom);
        return newRoom;
    }
}