import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        
        Set<Integer> hand = new HashSet<>();
        
        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
        }
        
        int cardsIdx = n / 3;
        
        Set<Integer> pending = new HashSet<>();
        
        while (cardsIdx < n) {
            pending.add(cards[cardsIdx]);
            cardsIdx += 1;
            pending.add(cards[cardsIdx]);
            cardsIdx += 1;
            
            boolean isFound = false;
            // 1. only cards in hand
            for (int c : hand) {
                if (hand.contains(n + 1 - c)) {
                    isFound = true;
                    hand.remove(n + 1 - c);
                    hand.remove(c);
                    break;
                }
            }
            
            // 2. one from hand, one from pending, coin >= 1
            if (!isFound && coin >= 1) {
                for (int c : hand) {
                    if (pending.contains(n + 1 - c)) {
                        isFound = true;
                        hand.remove(c);
                        pending.remove(n + 1 - c);
                        coin -= 1;
                        break;
                    }
                }
            }
            
            // 3. only cards in pending, coin >= 2
            if (!isFound && coin >= 2) {
                for (int c : pending) {
                    if (pending.contains(n + 1 - c)) {
                        isFound = true;
                        pending.remove(c);
                        pending.remove(n + 1 - c);
                        coin -= 2;
                        break;
                    }
                }
            }
            
            // 4. if not break
            if (!isFound) break;
            
            answer += 1;
        }
        
        return answer;
    }
}