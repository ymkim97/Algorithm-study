import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int maxSize, count;
	static int[] mx = {1, -1, 0, 0};
	static int[] my = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (map[i][j] == 1 && !visited[i][j]) {
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.println(count);
        System.out.println(maxSize);
	}
	
	public static void bfs(int a, int b) {
		int size = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			size += 1;
			
			for (int i = 0; i < 4; i++) {
				int dx = x + mx[i];
				int dy = y + my[i];
				
				if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy] || map[dx][dy] != 1) continue;
				
				visited[dx][dy] = true;
				q.offer(new int[] {dx, dy});
			}
		}
		
		
		maxSize = Math.max(size, maxSize);
		count += 1;
	}
}