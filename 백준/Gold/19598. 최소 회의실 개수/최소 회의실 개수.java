import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        int answer = 0;
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            times[i][0] = a;
            times[i][1] = b;
        }
        
        Arrays.sort(times, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            
            return a[1] - b[1];
        });
        
        for (int i = 0; i < N; i++) {
            int a = times[i][0];
            int b = times[i][1];
            
            while (!q.isEmpty() && a >= q.peek()) {
                q.poll();
            }
            
            q.offer(b);
            answer = Math.max(answer, q.size());
        }
        
        System.out.println(answer);
    }
}