import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        char d = st.nextToken().charAt(0);
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            
            for (char c : number.toCharArray()) {
                if (c == d) answer += 1;
            }
        }
        
        System.out.println(answer);
    }
}