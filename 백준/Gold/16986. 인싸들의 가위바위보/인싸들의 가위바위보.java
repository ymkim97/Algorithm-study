import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[][] map;
    static int[] idx = new int[3];
    static int[] win = new int[3];
    static int[][] arr = new int[3][];
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        map = new int[N+1][N+1];
        arr[0] = new int[N];
        arr[1] = new int[20];
        arr[2] = new int[20];

        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++)
                map[i][j] = Integer.parseInt(input[j-1]);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<20; i++)
            arr[1][i] = Integer.parseInt(input[i]);

        input = br.readLine().split(" ");
        for(int i=0; i<20; i++)
            arr[2][i] = Integer.parseInt(input[i]);

        boolean[] selected = new boolean[N+1];
        dfs(0, selected);
        System.out.println(ans);
    }

    public static void dfs(int n, boolean[] selected) {
        if(n==N) {
            for(int i=0; i<3; i++) {
                idx[i]=0;
                win[i]=0;
            }
            game(0, 1);
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!selected[i]) {
                selected[i] = true;
                arr[0][n] = i;
                dfs(n+1, selected);
                selected[i] = false;
            }
        }
    }

    public static void game(int player1, int player2) {
        boolean[] flag = new boolean[3];
        flag[player1] = true;
        flag[player2] = true;
        int winner = 0;

        if(map[arr[player1][idx[player1]]][arr[player2][idx[player2]]]==2)
            winner = player1;

        else if(map[arr[player1][idx[player1]]][arr[player2][idx[player2]]]==1)
            winner = Math.max(player1, player2);

        else if(map[arr[player1][idx[player1]]][arr[player2][idx[player2]]]==0)
            winner = player2;

        win[winner]++;
        idx[player1]++;
        idx[player2]++;

        if(win[1]==K || win[2]==K) return;

        if(win[0]==K) {
            ans = 1;
            return;
        }

        if(idx[0]>=N) return;

        for(int i=0; i<3; i++) {
            if(!flag[i])
                game(winner, i);
        }
    }
}