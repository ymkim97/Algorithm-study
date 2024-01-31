import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
            long answer = 0;
            int N = Integer.parseInt(br.readLine());
            int[] stock = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = stock[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (stock[i] > max) {
                    max = stock[i];
                }
                
                else {
                    answer += max - stock[i];
                }
            }
            
            System.out.println(answer);
        }
    }
}