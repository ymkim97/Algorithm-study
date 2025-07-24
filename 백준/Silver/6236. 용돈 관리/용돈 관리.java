import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[N];
        
        int start = 0;
        int end = 100_000 * 10_000;;

        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, day[i]);
        }

        start -= 1;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (check(day, mid) > M) {
            	start = mid;
            } else {
            	end = mid;
            }
        }
        
        System.out.println(end);
    }

    public static int check(int[] amount, int money) {
        int count = 1;
        int current = money;
        
        for (int a : amount) {
            current -= a;
            
            if (current < 0) {
                count += 1;
                current = money - a;
            }
        }
        
        return count;
    }
}