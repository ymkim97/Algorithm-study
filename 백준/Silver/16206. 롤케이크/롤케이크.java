import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st =  new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
                .comparingInt((Integer num) -> num % 10)
                .thenComparingInt(num -> num));
        
        int count = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num == 10) {
                count++;
                continue;
            }
            
            if (num < 10) continue;

            pq.add(num);
        }

        while (M > 0 && !pq.isEmpty()) {
            Integer poll = pq.poll();

            if (poll - 10 == 10) {
                count++;
            }

            if (poll - 10 > 10) {
                pq.add(poll - 10);
            }

            count++;
            M--;
        }

        System.out.println(count);
	}
}