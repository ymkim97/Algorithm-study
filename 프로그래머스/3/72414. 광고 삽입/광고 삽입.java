import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        if (play_time.equals(adv_time)) return "00:00:00";
        
        int playTime = toIntTime(play_time);
        int advTime = toIntTime(adv_time);
        
        long[] playCnt = new long[playTime + 1];
        for (String log : logs) {
            String[] l = log.split("-");
            playCnt[toIntTime(l[0])]++;
            playCnt[toIntTime(l[1])]--;
        }
        
        for (int i = 1; i < playCnt.length; i++) playCnt[i] += playCnt[i - 1];
        for (int i = 1; i < playCnt.length; i++) playCnt[i] += playCnt[i - 1];
        
        long maxTime = playCnt[advTime - 1];
        long maxStartTime = 0;
        
        for (int i = 0; i + advTime <= playTime; i++) {
            long tmp = playCnt[i + advTime] - playCnt[i];
            
            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }
        
        return toStringTime(maxStartTime, maxTime);
    }
    
    public int toIntTime(String time) {
        String[] sliced = time.split(":");
        int hour = Integer.parseInt(sliced[0]) * 3600;
        int min = Integer.parseInt(sliced[1]) * 60;
        int sec = Integer.parseInt(sliced[2]);
        
        return hour + min + sec;
    }
    
    public String toStringTime(long maxStartTime, long maxTime) {
        long hour = maxStartTime / 3600;
        long min = ((maxStartTime) / 60) % 60;
        long sec = maxStartTime % 60;
        
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}