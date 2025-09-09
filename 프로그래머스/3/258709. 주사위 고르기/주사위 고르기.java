import java.util.*;

class Solution {
    
    List<Integer> answer = new ArrayList<>();
    double maxWinRate = 0;
    
    public int[] solution(int[][] dice) {
        bruteForce(0, new ArrayList<>(), dice);
        
        Collections.sort(answer);
        return answer.stream().mapToInt(a -> a + 1).toArray();
    }
    
    private void bruteForce(int idx, List<Integer> aDices, int[][] dice) {
        if (aDices.size() == dice.length / 2) {
            calculateWinRate(aDices, dice);
            return;
        }
        
        for (int i = idx; i < dice.length; i++) {
            aDices.add(i);
            bruteForce(i + 1, aDices, dice);
            aDices.remove(Integer.valueOf(i));
        }
    }
    
    private void calculateWinRate(List<Integer> aDices, int[][] dice) {
        List<Integer> bDices = new ArrayList<>();
        
        for (int i = 0; i < dice.length; i++) {
            if (!aDices.contains(i)) bDices.add(i);
        }
        
        List<Integer> aCombs = new ArrayList<>();
        List<Integer> bCombs = new ArrayList<>();
        
        calculateCombination(0, dice, aDices, aCombs, 0);
        calculateCombination(0, dice, bDices, bCombs, 0);
        
        Collections.sort(aCombs);
        Collections.sort(bCombs);
        
        int wins = 0;
        
        for (int a : aCombs) {
            int left = -1;
            int right = bCombs.size();
            
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                
                if (bCombs.get(mid) >= a) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            
            wins += left + 1;
        }
        
        double rate = (double)wins / aCombs.size() * bCombs.size();
        
        if (rate > maxWinRate) {
            maxWinRate = rate;
            answer = new ArrayList<>(aDices);
        }
    }
    
    private void calculateCombination(int idx, int[][] dice, List<Integer> diceType, List<Integer> combs, int sum) {
        if (idx == diceType.size()) {
            combs.add(sum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            sum += dice[diceType.get(idx)][i];
            calculateCombination(idx + 1, dice, diceType, combs, sum);
            sum -= dice[diceType.get(idx)][i];
        }
    }
}