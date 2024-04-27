import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine()); //0 뻔, 1 데기
        
        int zero = 0;
        int one = 0;
        int repeat = 2;
        
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 ==0) {
                    zero += 1;
                }
                
                else {
                    one += 1;
                }
                
                if ((type == 0 && zero == T) || (type == 1 && one == T)) {
                    System.out.println((zero + one - 1) % A);
                    return;
                }
            }
            
            for (int i = 0; i < repeat; i++) {
                zero += 1;
                if (type == 0 && zero == T) {
                    System.out.println((zero + one - 1) % A);
                    return;
                }
            }
            
            for (int i = 0; i < repeat; i++) {
                one += 1;
                if (type == 1 && one == T) {
                    System.out.println((zero + one - 1) % A);
                    return;
                }
            }
            
            repeat += 1;
        }
    }
}