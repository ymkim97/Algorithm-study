import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper;
    static int N;
    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private static void dfs(int startX, int startY, int size) {
        int start = paper[startX][startY];
        boolean isDiff = false;

        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (paper[i][j] != start) {
                    isDiff = true;
                    break;
                }
            }
        }

        if (!isDiff) {
            if (start == -1) minusOneCount += 1;
            else if (start == 0) zeroCount += 1;
            else oneCount += 1;

            return;
        }

        int div = size / 3;

        dfs(startX, startY, div);
        dfs(startX, startY + div, div);
        dfs(startX, startY + div * 2, div);

        dfs(startX + div, startY, div);
        dfs(startX + div, startY + div, div);
        dfs(startX + div, startY + div * 2, div);

        dfs(startX + div * 2, startY, div);
        dfs(startX + div * 2, startY + div, div);
        dfs(startX + div * 2, startY + div * 2, div);
    }
}
