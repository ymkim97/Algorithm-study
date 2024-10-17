import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        
        for (String info : musicinfos) {
            String[] infos = info.split(","); //0: start, 1: end, 2: title, 3: code
            
            int start = convertToMin(infos[0]);
            int end = convertToMin(infos[1]);
            int duration = end - start;
            
            StringBuilder played = new StringBuilder();
            
            String code = infos[3];
            code = code.replace("C#", "c");
            code = code.replace("D#", "d");
            code = code.replace("F#", "f");
            code = code.replace("G#", "g");
            code = code.replace("A#", "a");
            code = code.replace("B#", "b");
            
            int codeLength = code.length();
            
            for (int i = 0; i < duration / codeLength; i++) {
                played.append(code);
            }
            
            for (int i = 0; i < duration % codeLength; i++) {
                played.append(code.charAt(i));
            }
            
            if (played.toString().contains(m) && duration > maxPlayTime) {
                maxPlayTime = duration;
                answer = infos[2];
            }
        }
        
        return answer;
    }
    
    public int convertToMin(String time) {
        String[] splited = time.split(":");
        
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }
}