import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
     
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] s = new long[N + 1];
        long[] cnt = new long[M];
        long result = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % M;
            
            if (s[i] == 0) result += 1;
            
            cnt[(int)s[i]] += 1;
        }
        
        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) result += (cnt[i] * (cnt[i] - 1)) / 2;
        }
        
        System.out.println(result);
    }
}