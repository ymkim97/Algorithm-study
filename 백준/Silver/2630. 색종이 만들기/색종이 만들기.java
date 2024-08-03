import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static int[][] map;
	static int blue = 0, white = 0;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dfs(0, 0, N, map);
        
        System.out.println(white);
        System.out.print(blue);
	}
	
	public static void dfs(int x, int y, int limit, int[][] map) {
		boolean isOrder = true;
		int flag = map[x][y];
		
		for (int i = x; i < x + limit; i++) {
			for (int j = y; j < y + limit; j++) {
				if (map[i][j] != flag) {
					isOrder = false;
					break;
				}
			}
		}
		
		if (isOrder) {
			if (flag == 1) blue++;
			else white++;
			
			return;
		}
		
		dfs(x, y, limit / 2, map);
		dfs(x + limit / 2, y, limit / 2, map);
		dfs(x, y + limit / 2, limit / 2, map);
		dfs(x + limit / 2, y + limit / 2, limit / 2, map);
	}
}