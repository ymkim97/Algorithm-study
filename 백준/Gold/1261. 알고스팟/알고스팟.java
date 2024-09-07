import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < M; j++) {
        		map[i][j] = Character.getNumericValue(input.charAt(j));
        	}
        }
        
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 0: x, 1: y, 2: block
        
        pq.offer(new int[] {0, 0, 0});
        
        while (!pq.isEmpty()) {
        	int[] now = pq.poll();
        	int x = now[0];
        	int y = now[1];
        	int block = now[2];
        	
        	if (x == N - 1 && y == M - 1) {
        		System.out.println(block);
        		return;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int dx = x + mx[i];
        		int dy = y + my[i];
        		
        		if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy]) continue;
        		
        		visited[dx][dy] = true;
        		
        		if (map[dx][dy] == 1) pq.offer(new int[] {dx, dy, block + 1});
        		else pq.offer(new int[] {dx, dy, block});
        	}
        }
	}
}