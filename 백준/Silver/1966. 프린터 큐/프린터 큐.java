import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < testCount; test++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int number = Integer.parseInt(st.nextToken());
                q.offer(new int[] {number, i});
                pq.offer(number);
            }

            int turn = 1;

            while (!q.isEmpty()) {
                if (pq.peek() > q.peek()[0]) {
                    q.offer(q.poll());
                    continue;
                }

                int[] now = q.poll();
                pq.poll();

                if (now[1] == M) break;

                turn += 1;
            }

            sb.append(turn).append("\n");
        }

        System.out.println(sb.toString());
    }
}
