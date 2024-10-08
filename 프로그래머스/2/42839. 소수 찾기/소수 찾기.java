import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        List<Integer> lst = new ArrayList<>();
        
        getAllNumbers(lst, numbers, new boolean[numbers.length()], new StringBuilder());       
        
        for (int t : lst) {
            if (t >= 2 && isPrime(t)) answer += 1;
        }
       
        return answer;
    }
    
    public void getAllNumbers(List<Integer> lst, String numbers, boolean[] visited, StringBuilder tmp) {
        if (tmp.length() != 0) {
            int t = Integer.parseInt(tmp.toString());
            
            if (!lst.contains(t)) lst.add(t);
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                tmp.append(numbers.charAt(i));
                getAllNumbers(lst, numbers, visited, tmp);
                tmp.deleteCharAt(tmp.length() - 1);
                
                visited[i] = false;
            }
        }
    }
                
    public boolean isPrime(int t) {
        for (int i = 2; i < (int)Math.sqrt(t) + 1; i++) {
            if (t % i == 0) return false;
        }
        
        return true;
    }
}