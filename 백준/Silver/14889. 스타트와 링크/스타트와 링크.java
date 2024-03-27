import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        board = new int[N + 1][N + 1];
        
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(new HashSet<Integer>(), 1);
        
        System.out.println(answer);
    }
    
    public static void dfs(Set<Integer> set, int start) {
        if (set.size() == N / 2) {
            
            int sum1 = 0;
            int sum2 = 0;
            
            int[] tmp1 = new int[N / 2];
            int[] tmp2 = new int[N / 2];
            
            int idx1 = 0;
            int idx2 = 0;
            for (int i = 1; i < N + 1; i++) {
                if (set.contains(i)) tmp1[idx1++] = i;
                else tmp2[idx2++] = i;
            }
            
            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    sum1 += board[tmp1[i]][tmp1[j]] + board[tmp1[j]][tmp1[i]];
                }
            }
            
            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    sum2 += board[tmp2[i]][tmp2[j]] + board[tmp2[j]][tmp2[i]];
                }
            }
            
            answer = Math.min(answer, Math.abs(sum1 - sum2));
            
            return;
        }
        
        for (int i = start; i < N + 1; i++) {
            if (!set.contains(i)) {
                set.add(i);
                dfs(set, i + 1);
                set.remove(i);
            }
        }
    }
}