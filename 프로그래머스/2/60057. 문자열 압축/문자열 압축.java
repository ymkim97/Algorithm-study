import java.util.*;

class Solution {
    
    public List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < source.length(); i += length) {
            int j = i + length;
            if (j > source.length())
                j = source.length();
            tokens.add(source.substring(i, j));    
        }
        
        return tokens;
    }
    
    public int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        
        for (String token: split(source, length)) {
            if (token.equals(last))
                count++;
            else{
                if (count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }       
        }
        
        if (count > 1) builder.append(count);
        builder.append(last);
        
        return builder.length();
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for (int length = 1; length <= s.length(); length++) {
            // 압축 후 비교 - compress()
            int compressed = compress(s, length);
            if (compressed < min)
                min = compressed;
        }
        
        return min;
    }
}