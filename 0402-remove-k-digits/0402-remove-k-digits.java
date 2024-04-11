class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num.length(); i++) {
            while(k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            
            if(!sb.isEmpty() || num.charAt(i) != '0')
                sb.append(num.charAt(i));
        }
        
        while(k > 0 && !sb.isEmpty()){
            sb.setLength(sb.length() - 1);
            k--;            
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}