class Solution {
    public int[] solution(String s) {
        int removedZero = 0;
        int convert = 0;
        
        while (!s.equals("1")) {
            int originLength = s.length();
            
            s = s.replace("0", "");
            
            int afterLength = s.length();
            
            removedZero += originLength - afterLength;
            
            s = toBin(s.length());
            convert += 1;
        }
        
        return new int[] {convert, removedZero};
    }
    
    public String toBin(int n) {       
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        
        return sb.reverse().toString();
    }
}