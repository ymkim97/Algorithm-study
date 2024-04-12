import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bluerays = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bluerays[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = Arrays.stream(bluerays).max().getAsInt();
        int right = 100_000 * 10_000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int cnt = check(mid, bluerays);
            
            if (cnt <= M) {
                answer = mid;
                right = mid - 1;
            }
            
            else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static int check(int size, int[] bluerays) {
        int tmp = 0;
        int count = 0;
        
        for (int b : bluerays) {
            if (tmp + b >= size) {
                if (tmp + b == size) tmp = 0;
                else tmp = b;

                count += 1;
            }
            
            else {
                tmp += b;
            }
        }
        
        if (tmp != 0) count += 1;
        
        return count;
    }
}