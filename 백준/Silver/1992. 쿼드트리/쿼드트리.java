import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] image;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        image = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] c = s.toCharArray();
            
            for (int j = 0; j < N; j++) {
                image[i][j] = Character.getNumericValue(c[j]);
            }
        }
        
        if (N == 1) {
            System.out.println(image[0][0]);
            return;
        }
        
        int t = image[0][0];
        boolean check = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (image[i][j] != t) check = false;
            }
        }
        
        if (check) {
            System.out.println(image[0][0]);
            return;
        }
        
        sb.append("(");
        dfs(0, 0, N / 2);
        dfs(0, N / 2, N / 2);
        dfs(N / 2, 0, N / 2);
        dfs(N / 2, N / 2, N / 2);
        sb.append(")");
        
        System.out.println(sb.toString());
    }
    
    public static void dfs(int startX, int startY, int length) {
        int type = image[startX][startY];
        boolean isSame = true;
        
        for (int i = startX; i < startX + length; i++) {
            for (int j = startY; j < startY + length; j++) {
                if (image[i][j] != type) isSame = false;
            }
        }
        
        if (isSame) {
            sb.append(type);
            return;
        }
        
        sb.append("(");
        dfs(startX, startY, length / 2);
        dfs(startX, startY + length / 2, length / 2);
        dfs(startX + length / 2, startY, length / 2);
        dfs(startX + length / 2, startY + length / 2, length / 2);
        sb.append(")");
        
    }
}
