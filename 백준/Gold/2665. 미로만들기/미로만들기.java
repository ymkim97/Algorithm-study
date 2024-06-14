import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	String line = br.readLine();
        	
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Character.getNumericValue(line.charAt(j));
        	}
        }
        
        int answer = 0;
        
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.blockCnt - b.blockCnt);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new Node(0, 0, 0));
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
        	Node now = pq.poll();
        	int x = now.a;
        	int y = now.b;
        	int blocks = now.blockCnt;
        	
        	if (x == n - 1 && y == n - 1) {
        		answer = blocks;
        		break;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int dx = x + mx[i];
        		int dy = y + my[i];
        		
        		if (dx < 0 || dy < 0 || dx >= n || dy >= n || visited[dx][dy]) continue;
        		
        		if (map[dx][dy] == 0) pq.offer(new Node(dx, dy, blocks + 1));
        		else pq.offer(new Node(dx, dy, blocks));
        		
        		visited[dx][dy] = true;
        	}
        }
        
        System.out.println(answer);
	}
	
	static class Node {
		int a;
		int b;
		int blockCnt;
		
		public Node(int a, int b, int blockCnt) {
			this.a = a;
			this.b = b;
			this.blockCnt = blockCnt;
		}
	}
}