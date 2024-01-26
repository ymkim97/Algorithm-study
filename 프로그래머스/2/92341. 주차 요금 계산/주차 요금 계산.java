import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();
        Map<String, Integer> parked = new HashMap<>();
        List<String> numbers = new ArrayList<>();
        
        for (String record : records) {
            String[] recs = record.split(" ");
            String[] time = recs[0].split(":");
            if (!numbers.contains(recs[1])) {
                numbers.add(recs[1]);
            }
                
            if (parked.containsKey(recs[1])) { // 주차되어있는 경우
                int enteredTime = parked.get(recs[1]);
                int currentTime = 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
                
                result.put(recs[1], result.getOrDefault(recs[1], 0) + currentTime - enteredTime);
                parked.remove(recs[1]);
            }
            
            else { // 입차인 경우
                parked.put(recs[1], 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]));
            }
        }
                
        Collections.sort(numbers);
        
        for (String number : numbers) {
            if (parked.containsKey(number)) { // 출차 안한 차
                int enteredTime = parked.get(number);
                int currentTime = 60 * 23 + 59;
                result.put(number, result.getOrDefault(number, 0) + currentTime - enteredTime);
            }
            
            int time = result.get(number);
            
            if (time <= fees[0]) {
                answer.add(fees[1]);
            }
            
            else {
                answer.add(fees[1] + (int)Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3]);
            }
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}