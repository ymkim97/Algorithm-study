import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int min = Integer.MAX_VALUE;
        long sum = 0;
        
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (min == Integer.MAX_VALUE) min = i;
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(sum);
        System.out.println(min);
    }
    
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}