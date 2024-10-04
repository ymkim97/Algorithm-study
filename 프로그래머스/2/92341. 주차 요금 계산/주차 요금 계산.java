import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        Map<Integer, Integer> idAndTimeSum = new HashMap<>();
        Map<Integer, Integer> ins = new HashMap<>();
        
        for (String record : records) {
            String[] cmd = record.split(" ");
            
            int time = convertTime(cmd[0]);
            int carId = Integer.parseInt(cmd[1]);
            String dir = cmd[2];
            
            if (dir.equals("IN")) {
                ins.put(carId, time);
            } else {
                int inTime = ins.get(carId);
                ins.remove(carId);
                
                int duration = time - inTime;
                
                
                idAndTimeSum.put(carId, idAndTimeSum.getOrDefault(carId, 0) + duration);
            }
        }
        
        List<Integer> keys = new ArrayList<>(ins.keySet());
        
        for (int key : keys) {
            int inTime = ins.get(key);
            int duration = (23 * 60 + 59) - inTime;
            
            idAndTimeSum.put(key, idAndTimeSum.getOrDefault(key, 0) + duration);
        }
        
        keys = new ArrayList<>(idAndTimeSum.keySet());
        
        Collections.sort(keys);
        
        for (int key : keys) {
            int totalTime = idAndTimeSum.get(key);
            int fee = 0;
            
            if (totalTime <= fees[0]) fee = fees[1];
            else {
                fee = fees[1] + (int)Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
            }
            
            answer.add(fee);
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
    
    public int convertTime(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}