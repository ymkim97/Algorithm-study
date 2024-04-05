import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] amount = new int[N];
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            amount[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, amount[i]);
        }
        
        int left = max;
        int right = 100_000 * 10_000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (M < check(amount, mid)) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
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