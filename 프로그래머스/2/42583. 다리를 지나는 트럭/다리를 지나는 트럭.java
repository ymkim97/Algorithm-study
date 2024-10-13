import java.util.*;

class Solution {
    public int solution(int bridge_length, int maxWeight, int[] truck_weights) {        
        Queue<Integer> truckQ = new LinkedList<>();
        Queue<int[]> bridgeQ = new LinkedList<>(); //0: truckNum, 1: sec
        
        int finishedCnt = 0;
        int currentWeight = 0;
        int time = 0;
        
        for (int t : truck_weights) {
            truckQ.offer(t);
        }
        
        while (finishedCnt != truck_weights.length) {
            time += 1;
            
            while (!bridgeQ.isEmpty() && time - bridgeQ.peek()[1] == bridge_length) {
                int[] t = bridgeQ.poll();
                finishedCnt += 1;
                currentWeight -= t[0];
            }
                
            if (!truckQ.isEmpty()) {
                if (bridgeQ.size() < bridge_length && (currentWeight + truckQ.peek() <= maxWeight)) {
                    int truck = truckQ.poll();
                    bridgeQ.offer(new int[] {truck, time});
                    currentWeight += truck;
                }
            }            
        }
        
        return time;
    }
}