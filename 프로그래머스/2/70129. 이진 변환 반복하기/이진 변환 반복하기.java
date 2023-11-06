class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeros = 0;
        
        while (! s.equals("1")) {
            count += 1;
            
            int firstLength = s.length();
            s = s.replace("0","");
            zeros += firstLength - s.length();
            
            s = Integer.toString(s.length(), 2);
        }
        
        int[] answer = {count, zeros};
        
        return answer;
    }
}