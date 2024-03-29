import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            answer += a + b;
            pq.offer(a + b);
        }
        
        System.out.println(answer);
    }
}