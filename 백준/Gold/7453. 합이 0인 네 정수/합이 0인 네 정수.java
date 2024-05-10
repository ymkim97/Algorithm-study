import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] abcd = new int[n][4];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 4; j++) {
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = abcd[i][0] + abcd[j][1];
                cd[i * n + j] = abcd[i][2] + abcd[j][3];
            }
        }
        
        Arrays.sort(ab);
        Arrays.sort(cd);
        
        int abp = 0;
        int cdp = n * n - 1;
        long cnt = 0;
        
        while (abp < n * n && cdp >= 0) {
            long abv = ab[abp];
            long cdv = cd[cdp];
            long res = abv + cdv;
            
            if (res < 0) {
                abp += 1;
            } else if (res > 0) {
                cdp -= 1;
            } else {
                long xc = 0;
                long yc = 0;
                
                while (abp < n * n && abv == ab[abp]) {
                    xc += 1;
                    abp += 1;
                }
                
                while (cdp >= 0 && cdv == cd[cdp]) {
                    yc += 1;
                    cdp -= 1;
                }
                
                cnt += xc * yc;
            }
        }
        
        System.out.println(cnt);
    }
}