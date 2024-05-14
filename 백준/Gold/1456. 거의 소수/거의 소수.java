import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        boolean[] isPrime = new boolean[(int)Math.sqrt(b) + 1];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) continue;
            
            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
        
        int answer = 0;
        
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long temp = i;
                
                while (temp <= (double)b / i) {
                    if (temp >= (double)a / i) answer += 1;
                    
                    temp *= i;
                }
            }
        }
        
        System.out.println(answer);
    }
}