class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true;
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                isFirst = true;
                sb.append(c);   
            }
            
            else {
                if (isFirst && Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                }
                
                else if (!isFirst && Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                }
                
                else sb.append(c);
                
                isFirst = false;
            }
        }
        
        return sb.toString();
    }
}