import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> pr = new LinkedList<>();
        int[] answer = new int[prices.length];
        int count;
        int each;
        int index = 0;
        
        for(int price: prices) {
            pr.add(price);
        }
        
        while (pr.size() != 0) {
            each = pr.poll();
            count = 0;
            
            for(int price: pr) {
                count ++;
                if (each > price)
                    break;
            }
            answer[index] = count;
            index++;
        }
        
        return answer;
    }
}