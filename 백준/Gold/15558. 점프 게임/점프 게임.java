import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] avail = new int[2][N];
        
        String f = br.readLine();
        String s = br.readLine();

        for (int i = 0; i < N; i++) {
        	avail[0][i] = Character.getNumericValue(f.charAt(i));
        	avail[1][i] = Character.getNumericValue(s.charAt(i));
        }
        
        boolean[][] visited = new boolean[2][N];
        
        visited[0][0] = true;
        
        Queue<int[]> q = new LinkedList<>(); // 0: row number, 1: place
        q.offer(new int[] {0, 0, 0});
        
        while (!q.isEmpty()) {
        	int[] now = q.poll();
        	int row = now[0];
        	int place = now[1];
        	int minimumMove = now[2];
        	
        	int aMove = place + 1;
        	int bMove = place - 1;
        	int cMove = place + k;
        	
        	if (aMove >= N || bMove >= N || cMove >= N) {
        		System.out.println(1);
        		return;
        	}
        	
        	if (avail[row][aMove] == 1 && !visited[row][aMove] && aMove > minimumMove) {
        		visited[row][aMove] = true;
        		q.offer(new int[] {row, aMove, minimumMove + 1});
        	}
        	
        	if (bMove >= 0 && avail[row][bMove] == 1 && !visited[row][bMove] && bMove > minimumMove) {
        		visited[row][bMove] = true;
        		q.offer(new int[] {row, bMove, minimumMove + 1});
        	}
        	
        	if (avail[(row + 1) % 2][cMove] == 1 && !visited[(row + 1) % 2][cMove]) {
        		visited[(row + 1) % 2][cMove] = true;
        		q.offer(new int[] {((row + 1) % 2), cMove, minimumMove + 1});
        	}
        }
        
        System.out.println(0);
    }
}