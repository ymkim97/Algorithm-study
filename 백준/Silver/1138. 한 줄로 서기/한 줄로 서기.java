import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int num = i + 1;
            int idx = Integer.parseInt(st.nextToken());
            
            int tmp = 0;
            
            for (int j = 0; j < N; j++) {
                if (tmp == idx && answer[j] == 0) {
                    answer[j] = num;
                    break;
                }
                
                if (answer[j] == 0) tmp += 1;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (i == N - 1) System.out.printf("%d\n", answer[i]);
            else System.out.printf("%d ", answer[i]);
        }
    }
}