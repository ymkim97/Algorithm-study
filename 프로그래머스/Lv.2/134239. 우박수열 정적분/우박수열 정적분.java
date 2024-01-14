import java.util.*;

class Solution {
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int[] y = getYs(k);
        int n = y.length - 1;
        
        double[] sum = new double[y.length];
        for (int i = 1; i < y.length; i++) {
            sum[i] = calculate(y[i], y[i - 1]);
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if (a == b) {
                answer[i] = 0.0;
            }
            
            else if (a > b) {
                answer[i] = -1.0;
            }
            
            else {
                double tmp = 0;
                for (int m = a + 1; m <= b; m++) {
                    tmp += sum[m];
                }
                answer[i] = tmp;
            }
        }
        
        return answer;
    }
    
    public int[] getYs(int k) {
        List<Integer> yList = new ArrayList<>();
        yList.add(k);
        
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            }
            
            else {
                k = k * 3 + 1;
            }
            
            yList.add(k);
        }
        
        return yList.stream().mapToInt(a -> a).toArray();   
    }
    
    public double calculate(int y, int prevY) {
        double result = Math.min(y, prevY);
        
        return result + (0.5 * Math.abs(y - prevY));
    }
}