import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> parked = new HashMap<>();
        Map<Integer, Integer> parkTimeAcc = new HashMap<>();
        
        for (String r : records) {
            String[] splt = r.split(" ");
            
            String time = splt[0];
            int carNumber = Integer.parseInt(splt[1]);
            String inOrOut = splt[2];
            
            int hour = Integer.valueOf(time.split(":")[0]);
            int min = Integer.valueOf(time.split(":")[1]);
            
            int totalTime = hour * 60 + min;
            
            if (inOrOut.equals("IN")) {
                parked.put(carNumber, totalTime);
            } else {
                int in = parked.get(carNumber);
                parked.remove(Integer.valueOf(carNumber));
                
                int duration = totalTime - in;
                parkTimeAcc.put(carNumber, parkTimeAcc.getOrDefault(carNumber, 0) + duration);
            }
        }
        
        if (!parked.isEmpty()) {
            for (int key : parked.keySet()) {
                int in = parked.get(key);
                
                int duration = 23 * 60 + 59 - in;
                parkTimeAcc.put(key, parkTimeAcc.getOrDefault(key, 0) + duration);
            }
        }
        
        int[] answer = new int[parkTimeAcc.size()];
        
        List<Integer> keys = new ArrayList<>(parkTimeAcc.keySet());
        Collections.sort(keys);
        
        for (int i = 0; i < answer.length; i++) {
            int tmp = fees[1];
            int duration = parkTimeAcc.get(keys.get(i));
            
            if (duration > fees[0]) {
                duration -= fees[0];

                int over = (int)Math.ceil((double)duration / fees[2]);
                tmp += over * fees[3];
            }
            
            answer[i] = tmp;
        }
        
        return answer;
    }
}