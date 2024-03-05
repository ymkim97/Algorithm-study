import java.util.*;

class Solution {
    
    int[] discountPercent = {10, 20, 30, 40};
    int[][] users;
    int[] emoticons;
    List<int[]> answer;
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new ArrayList<>();
        this.users = users;
        this.emoticons = emoticons;
        
        for (int i = 0; i < 4; i++) {
            List<int[]> discounted = new ArrayList<>();
            int d = (int)(emoticons[0] - emoticons[0] * (discountPercent[i] / 100.0));
            discounted.add(new int[] {discountPercent[i], d});
            calculate(discounted, 1);
        }
        
        Collections.sort(answer, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            
            return b[1] - a[1];
        });
        
        return answer.get(0);
    }
    
    public void calculate(List<int[]> discounted, int nextIdx) { // discounted[0] = per, 1 = amount
        if (nextIdx == emoticons.length) {
            int plusUser = 0;
            int sumOfSales = 0;

            for (int[] user : users) {
                int disFrom = user[0];
                int plusAfter = user[1];
                int tmpTotal = 0;
                
                for (int[] dis : discounted) {
                    if (dis[0] >= disFrom) {
                        tmpTotal += dis[1];
                    }
                }
                
                if (tmpTotal >= plusAfter) {
                    plusUser += 1;
                }
                
                else {
                    sumOfSales += tmpTotal;
                }
            }
            
            answer.add(new int[] {plusUser, sumOfSales});
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int d = (int)(emoticons[nextIdx] - emoticons[nextIdx] * (discountPercent[i] / 100.0));
            discounted.add(new int[] {discountPercent[i], d});
            calculate(discounted, nextIdx + 1);
            discounted.remove(discounted.size() - 1);
        }
    }
}