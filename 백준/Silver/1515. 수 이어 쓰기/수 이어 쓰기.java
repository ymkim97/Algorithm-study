import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String s = br.readLine();
        
        int base = 0;
        int pointer = 0;
        
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pointer)) {
                    pointer += 1;
                }
                
                if (pointer == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}