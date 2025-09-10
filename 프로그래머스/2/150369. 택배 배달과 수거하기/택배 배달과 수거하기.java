import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<int[]> delivery = new Stack<>(); // 0: house, 1: amount
        Stack<int[]> pickup = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                delivery.push(new int[] {i + 1, deliveries[i]});
            }
            
            if (pickups[i] != 0) {
                pickup.push(new int[] {i + 1, pickups[i]});
            }
        }
        
        while (!delivery.isEmpty() || !pickup.isEmpty()) {
            int delCount = 0;
            int picCount = 0;
            
            int dHouse = delivery.isEmpty() ? 0 : delivery.peek()[0];
            int pHouse = pickup.isEmpty() ? 0 : pickup.peek()[0];
            
            answer += Math.max(dHouse, pHouse) * 2;
            
            while (!delivery.isEmpty() && delCount < cap) {
                if (delivery.peek()[1] + delCount <= cap) {
                    int[] d = delivery.pop();
                    delCount += d[1];
                } else if (delivery.peek()[1] + delCount > cap) {
                    int[] d = delivery.pop();
                    d[1] -= cap - delCount;
                    delivery.push(d);
                    break;
                }
            }
            
            while (!pickup.isEmpty() && picCount < cap) {
                if (pickup.peek()[1] + picCount <= cap) {
                    int[] d = pickup.pop();
                    picCount += d[1];
                } else if (pickup.peek()[1] + picCount > cap) {
                    int[] d = pickup.pop();
                    d[1] -= cap - picCount;
                    pickup.push(d);
                    break;
                }
            }
        }
        
        return answer;
    }
}