import java.io.*;
import java.util.*;

class Main {
    
    static int T;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        
        for (int cnt = 0; cnt < T; cnt++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] novel = new int[K];
            
            for (int i = 0; i < K; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
            }
            
            System.out.println(solve(novel));
        }
    }
    
    public static long solve(int[] novel) {
        long answer = 0;
        Queue<Long> pq = new PriorityQueue<>();
        
        for (int n : novel) {
            pq.offer((long)n);
        }
        
        while (pq.size() >= 2) {
            long a = pq.poll();
            long b = pq.poll();
            
            answer += a + b;
            pq.offer(a + b);
            
            if (pq.size() == 1) break;
        }
        
        return answer;
    }
}