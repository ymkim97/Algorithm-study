import java.io.*;
import java.util.*;

class Main {
    
    static int[][] table;
    static int N;
    static int max = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        table = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            table[i][0] = t;
            table[i][1] = p;
        }
        
        for (int i = 1; i <= N; i++) {
            dfs(i, table[i][1]);
        }
        
        
        System.out.println(max);
    }
    
    public static void dfs(int day, int profitSum) {
        if (day == N && table[day][0] != 1) {
            profitSum -= table[day][1];
        }
        
        if (day != N && day + table[day][0] > N + 1) {
            profitSum -= table[day][1];
        }
        
        if (profitSum > max) {
            max = profitSum;
        }
        
        for (int i = day + table[day][0]; i <= N; i++) {
            dfs(i, profitSum + table[i][1]);
        }
    }
}