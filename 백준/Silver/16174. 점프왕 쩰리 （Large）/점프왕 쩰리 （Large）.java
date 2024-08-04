import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[] mx = {0, 1};
        int[] my = {1, 0};
     
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
     
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int x = now[0];
        	int y = now[1];
        	
        	for (int i = 0; i < 2; i++) {
        		int dx = x + mx[i] * map[x][y];
        		int dy = y + my[i] * map[x][y];
        		
        		if (dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy]) continue;
        		
        		if (map[dx][dy] == -1) {
        			System.out.println("HaruHaru");
        			return;
        		}
        		
        		visited[dx][dy] = true;
        		q.offer(new int[] {dx, dy});
        	}
        }
        
        System.out.println("Hing");
	}
}