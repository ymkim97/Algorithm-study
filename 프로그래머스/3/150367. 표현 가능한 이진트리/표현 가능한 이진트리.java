import java.util.*;

class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bin = getBin(numbers[i]);
            
            int treeLength = 1;
            
            while (treeLength < bin.length()) {
                treeLength = treeLength * 2 + 1;
            }
            
            int beforeChange = bin.length();
            for (int a = 0; a < treeLength - beforeChange; a++) {
                bin = "0" + bin;
            }
      
            answer[i] = check(bin) ? 1 : 0;
        }
        
        return answer;
    }
    
    public String getBin(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    public boolean check(String bin) {
        int len = bin.length();
        if (len == 0) return true;
        
        char parent = bin.charAt(len / 2);
        String leftSubTree = bin.substring(0, len / 2);
        String rightSubTree = bin.substring(len / 2 + 1);
        
        if(parent == '0') {
            return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
        }
        
        return check(leftSubTree) && check(rightSubTree);
    }
    
    public boolean isZeroTree(String bin) {
        int len = bin.length();
        if (len == 0) return true;
        
        char parent = bin.charAt(len / 2);
        String leftSubTree = bin.substring(0, len / 2);
        String rightSubTree = bin.substring(len / 2 + 1);
        
        if (parent == '1') return false;
        
        return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
    }
}