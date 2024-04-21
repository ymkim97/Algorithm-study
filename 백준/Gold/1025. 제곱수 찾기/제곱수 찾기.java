import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        int result = -1;
        
        for (int i = 0; i < N; i++) {
            char[] letters = br.readLine().toCharArray();
            
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(letters[j]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int mi = -N; mi < N; mi++) {
                    for (int mj = -M; mj < M; mj++) {
                        if (mi == 0 && mj == 0) continue;
                        
                        int t = 0;
                        int di = i;
                        int dj = j;
                        
                        while (di >= 0 && di < N && dj >= 0 && dj < M) {
                            t = 10 * t + arr[di][dj];
                            
                            if (Math.abs(Math.sqrt(t) - (int)Math.sqrt(t)) < 1e-10) {
                                result = Math.max(result, t);
                            }
                            
                            di += mi;
                            dj += mj;
                        }
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}
