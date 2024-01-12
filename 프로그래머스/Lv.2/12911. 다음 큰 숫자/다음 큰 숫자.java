class Solution {
    public int solution(int n) {
        int answer = 0;
        int ones = calculateBin(n);
        
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (calculateBin(i) == ones) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int calculateBin(int number) {
        int count = 0;
        
        while (number > 0) {
            int div = number / 2;
            int rest = number % 2;
            
            if (rest == 1) {
                count += 1;
            }
            number = div;
            
            if (number == 2) {
                count += 1;
                break;
            }
        }
        
        return count;
    }
}