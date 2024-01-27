import java.io.*;
import java.util.*;

class Main {
    
    static int n;
    static int[][] map;
    static boolean[][] colors;
    static boolean[][] visited;
    static int[] res = new int[2];
    static int[] dx = {-1,-1};
    static int[] dy = {1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        colors = new boolean[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                colors[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0); 
            }
        }
        
        solve(-1,true,0);
        solve(-1,false,0);
        
        System.out.println(res[0] + res[1]);
    }
    
    static void solve(int index, boolean color, int cnt) {
        for (int i = index + 1; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            
            // 현재 탐색중인 색이 아니거나, 놓을 수 없거나, 대각선에 비숍이 존재하거나
            if(colors[x][y] != color || map[x][y] == 0 || !check(x,y)) 
                continue;
            
            visited[x][y] = true;
            solve(i, color, cnt + 1);
            visited[x][y] = false;
        }
        res[color ? 1 : 0] = Math.max(res[color ? 1 : 0], cnt);
    }
    
    static boolean check(int x, int y) {
        // 임의의 순서를 지정해 0,0 부터 시작하므로 아래부분에는 비숍이 없다.
        // 따라서, 윗 대각선만 체크한다.
        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            
            while(true) {
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;

                if(visited[nx][ny]) return false;
                
                nx += dx[i];
                ny += dy[i];
            }
        }
        
        return true;
    }
}