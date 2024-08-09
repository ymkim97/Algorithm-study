import java.util.*;
import java.io.*;

class Main {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int wolf, sheep;
	static int[] mx = {1, -1, 0, 0};
	static int[] my = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
        	String line = br.readLine();
        	
        	for (int j = 0; j < C; j++) {
        		map[i][j] = line.charAt(j);
        	}
        }
        
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		if (map[i][j] != '#' && !visited[i][j]) {
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.printf("%d %d", sheep, wolf);
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		
		int tmpSheep = 0;
		int tmpWolf = 0;
		
		if (map[a][b] == 'o') tmpSheep += 1;
		else if (map[a][b] == 'v') tmpWolf += 1;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			
			for (int i = 0; i < 4; i++) {
				int dx = x + mx[i];
				int dy = y + my[i];
				
				if (dx < 0 || dy < 0 || dx >= R || dy >= C || visited[dx][dy] || map[dx][dy] == '#') continue;
				
				visited[dx][dy] = true;
				
				if (map[dx][dy] == 'o') tmpSheep += 1;
				else if (map[dx][dy] == 'v') tmpWolf += 1;
				
				q.offer(new int[] {dx, dy});
			}
		}
		
		if (tmpSheep > tmpWolf) {
			sheep += tmpSheep;
		}
		else {
			wolf += tmpWolf;
		}
	}
}