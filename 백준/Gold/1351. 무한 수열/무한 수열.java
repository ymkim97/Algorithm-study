import java.io.*;
import java.util.*;

class Main {
    
    static Map<Long, Long> map = new HashMap<>();
    static int P, Q;
    static long N;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        System.out.println(solve(N));
    }
    
    public static Long solve(long n) {
        if (n == 0) {
            return 1L;
        }
        
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        long a = (Long)n / P;
        long b = (Long)n / Q;
        
        map.put(n, solve(a) + solve(b));
        return map.get(n);
    }
}