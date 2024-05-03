import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        char[] S = br.readLine().toCharArray();
        String K = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : S) {
            if (Character.isDigit(c)) continue;
            
            sb.append(c);
        }
        
        String newS = sb.toString();
        
        int answer = newS.contains(K) ? 1 : 0;
        
        System.out.println(answer);
    }
}