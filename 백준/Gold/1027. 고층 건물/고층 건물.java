import java.io.*;
import java.util.*;

class Main {
    
    static int[] map;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, count(i));
        }
        
        System.out.println(ans);
    }
    
    public static int count(int idx) {
        int cnt = 0;
        double tmp = 0;
        
        for (int i = idx - 1; i >= 0; i--) {
            double slope = (double) (map[idx] - map[i]) / (idx - i);
            
            if (i == idx - 1 || tmp > slope) {
                cnt += 1;
                tmp = slope;
            }
        }
        
        for (int i = idx + 1; i < N; i++) {
            double slope = (double) (map[idx] - map[i]) / (idx - i);
            
            if (i == idx + 1 || tmp < slope) {
                cnt += 1;
                tmp = slope;
            }
        }
        
        return cnt;
    }
}