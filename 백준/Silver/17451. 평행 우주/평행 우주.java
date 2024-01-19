import java.io.*;
import java.util.*;

class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long answer = 0;
        
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        long[] planet = new long[n];
        
        for (int i = 0; i < n; i++) {
            planet[i] = Long.parseLong(st.nextToken());
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (planet[i] > answer) {
                answer = planet[i];
            }
            
            else if (planet[i] < answer && answer % planet[i] != 0) {
                answer = ((answer / planet[i]) + 1) * planet[i];
            }
        }
        
        System.out.println(answer);
    }
}