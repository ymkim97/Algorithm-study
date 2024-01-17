class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                left = number;
                answer += "L";
            }
            
            else if (number == 3 || number == 6 || number == 9) {
                right = number;
                answer += "R";
            }
            
            else {
                if (number == 0) number = 11;
                
                int leftDiff = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
                int rightDiff =(Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);
                
                if (leftDiff == rightDiff) {
                    if (hand.equals("right")) {
                        right = number;
                        answer += "R";
                    }
                    
                    else {
                        left = number;
                        answer += "L";
                    }
                }
                
                else if (leftDiff > rightDiff) {
                    right = number;
                    answer += "R";
                }
                
                else {
                    left = number;
                    answer += "L";
                }
            }
        }
        
        return answer;
    }
}