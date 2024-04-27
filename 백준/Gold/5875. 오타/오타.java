import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        String str = br.readLine();
        int left = 0;
        int right = 0;
        int total = 0;
        int result = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            
            if (val == '(') {
                left += 1;
                total += 1;
            } else {
                right += 1;
                total -= 1;
            }
            
            if (total == 1) left = 0;
            if (total == -1) {
                result = right;
                break;
            }
        }
        
        if (total == 2) result = left;
        
        System.out.println(result);
    }
}